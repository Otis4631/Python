# encoding:utf-8
import requests
import DBfun
import re
import os
import time
import socket
from bs4 import BeautifulSoup
socket.setdefaulttimeout(10)
# spider 1 获取各个公司招聘信息网址


headers = {
    'User-Agent': "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:51.0) Gecko/20100101 Firefox/51.0",
    'Referer': "https://www.lagou.com/?utm_source=m_cf_cpt_baidu_pc",
    'Host': "www.lagou.com"
}

def get_urls_from(channel, i):
    print("函数get_url已启动,PID:",os.getpid())
    db = DBfun.connectRDB()
    for page in range(1, 5):
        link = "{}{}/".format(channel[1], page)
        try:
            wb_data = requests.get(link, timeout=11, headers=headers)
        except Exception as error:
            print("channel-{}-page-{}链接打开失败，错误为：".format(i, page), error)
            continue
        wb_data.encoding = "utf-8"
        if wb_data.status_code == 404:
            print("网页未找到404")
            db.close()
            return 0
        else:
            soup = BeautifulSoup(wb_data.text, 'lxml')
            urls_tag = soup.select('div .p_top  a')
            category = str(soup.select(" #keyword")[0].get('value'))
            for url, j in zip(urls_tag, range(1,50)):
                url = 'http:' + url.get('href')
                UK = (re.search(r"\d+", url)).group()
                sql = "REPLACE INTO url_list(Mcategory ,url, category,uk)VALUES ('{}','{}','{}',{})".format(channel[0],url,category,UK)
                # print("准备将URL插入数据库-channel-{}-page-{}-url-{}".format(i, page, j))
                DBfun.insert_to_item(sql, db)
                time.sleep(2)
            print("channel-{} page-{} done".format(i, page))
    print("channel-{} done".format(category))
    db.close()

# spider 2 获取各个招聘详细信息


def get_item_from(Link):
    time.sleep(1)
    db = DBfun.connectRDB()
    link = Link[0]
    category = Link[1]
    Mcategory = Link[2]
    print(Link)
    try:
        wb_data = requests.get(link, timeout=15, headers=headers)
        print(wb_data.status_code)
        if wb_data.status_code == 404:
            print('404 Not Found')
            # switch_proxy()   修改代理地址
            return 0
    except Exception as error:
        print("item 连接失败，错误为：", error)
        return 0
    UK = (re.search(r"\d+", link)).group()
    soup = BeautifulSoup(wb_data.text, 'lxml')
    public_time = (
        soup.select(".publish_time")[0]).string.replace(
        "发布于拉勾网",
        "").replace(
            "\xa0",
        "").strip()
    if len(public_time) <= 5:
        Time = time.time() - (int(public_time[0]) * 60 * 60 * 24)
        public_time = time.strftime('%Y-%m-%d', time.localtime(Time))
    status = ''
    company_name = str((soup.select("h2.fl")[0]).next.strip())
    company_place = soup.select("div.work_addr")[0].text
    company_place = company_place.replace(
        '\n',
        '').replace(
        ' ',
        '').replace(
            "查看地图",
        "")
    try:
        if company_place[0] == '-':
            company_place = soup.select(".job_request  span")[1].string + company_place
    except Exception as error:
        print(error)
    company_num = soup.select(".icon-glyph-figure")[0].next.strip()
    company_development = soup.select(".icon-glyph-trend")[0].next.strip()
    position_description = soup.select(".job_bt > div")[0].text.replace('\xa0',"").replace('"',"'")
    pay = soup.select(".salary")[0].text
    requirement = ""
    # python 列表推导式
    temp = [
        s.string for s,
        i in zip(
            soup.select(".job_request  span"),
            range(0, 10)) if i > 1]
    requirement = requirement.join(temp)
    sql = '''
              REPLACE INTO item_info(
                                    Mcategory,
                                    link,
                                    UK,
                                    public_time,
                                    category,
                                    company_name,
                                    company_place,
                                    company_num,
                                    position_description,
                                    pay,
                                    requirement,
                                    company_development)
                    VALUES('{}','{}',{},'{}','{}',"{}",'{}','{}',"{}",'{}','{}','{}')
        '''.format(Mcategory,link, UK, public_time, category, company_name.replace("'","\'"), company_place.replace("'","\'"), company_num, position_description.replace("'","\'"), pay, requirement.replace("'","\'"), company_development)
    DBfun.insert_to_item(sql, db)
    print(UK,'以插入数据库...')
    db.close()
