# encoding:utf-8
import requests
import DBfun
import re
import os
import time
import socket
from multiprocessing import Queue
from bs4 import BeautifulSoup
from tqdm import tqdm
Q = Queue(30)
socket.setdefaulttimeout(10)
# spider 1 获取各个公司招聘信息网址

def isQempty():
    return Q.empty()
headers = {
    'User-Agent': "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:51.0) Gecko/20100101 Firefox/51.0",
    'Referer': "https://www.lagou.com/?utm_source=m_cf_cpt_baidu_pc",
    'Host': "www.lagou.com"
}


def get_urls_from(channel, i):
    print("函数get_url已启动,PID:",os.getpid())
    db = DBfun.connectRDB()
    for page in range(1, 50):
        link = "{}{}/".format(channel, page)
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
                Q.put((url, category), block=1)
                sql = "INSERT INTO url_list(url, category,uk) SELECT '{}', '{}', {} FROM DUAL WHERE NOT EXISTS(SELECT UK FROM url_list WHERE UK = {}); ".format(
                    url, category, UK, UK)
                print("准备将URL插入数据库-channel-{}-page-{}-url-{}".format(i, page, j))
                DBfun.insert_to_item(sql, db)
                time.sleep(2)
            print("channel-{} page-{} done".format(i, page))
    print("channel-{} done".format(category))
    db.close()

# spider 2 获取各个招聘详细信息


def get_item_from():
    time.sleep(1)
    db = DBfun.connectRDB()
    if(Q.empty()):
        time.sleep(4)
        if(Q.empty()):
            db.close()
            return 0
    print("当前URL队列总数：", Q.qsize())
    queue = Q.get()
    link = queue[0]
    category = queue[1]
    try:
        wb_data = requests.get(link, timeout=15, headers=headers)
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
    company_num = soup.select(".icon-glyph-figure")[0].next.strip()
    company_development = soup.select(".icon-glyph-trend")[0].next.strip()
    position_description = soup.select(".job_bt > div")[0].text.replace('\xa0',"")
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
                    VALUES({},'{}','{}','{}','{}','{}','{}','{}','{}','{}')
        '''.format(UK, public_time, category, company_name, company_place, company_num, position_description, pay, requirement, company_development)
    print("item信息正在插入数据库...")
    DBfun.insert_to_item(sql, db)
    db.close()
