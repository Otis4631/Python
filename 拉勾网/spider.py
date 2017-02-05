# encoding:utf-8
import requests
import DBfun
import re
import os
import time
import main
import socket
from bs4 import BeautifulSoup
from tqdm import tqdm

socket.setdefaulttimeout(10)
# spider 1 获取各个公司招聘信息网址


def Qsize():
    return main.Q.qsize()


def isQempty():
    # print(main.Q.empty())
    return main.Q.empty()
headers = {
    'User-Agent': "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:51.0) Gecko/20100101 Firefox/51.0",
    'Cookie': "Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486139701,1486185509,1486185589,1486185619; _ga=GA1.2.1890372085.1485665719; user_trace_token=20170129125522-23dec03d-e5df-11e6-bf15-525400f775ce; LGUID=20170129125522-23dec671-e5df-11e6-bf15-525400f775ce; index_location_city=%E5%85%A8%E5%9B%BD; SEARCH_ID=199a6cc81e2544d081b244e2a678b548; _gat=1; LGSID=20170204131955-906ee2e8-ea99-11e6-8f5f-525400f775ce; PRE_UTM=m_cf_cpt_baidu_pc; PRE_HOST=bzclk.baidu.com; PRE_SITE=http%3A%2F%2Fbzclk.baidu.com%2Fadrc.php%3Ft%3D06KL00c00f77lk60De7g0FNkUsKvuFNm00000jnzhH300000b5SUHc.THL0oUhY1x60UWYsnW0YrH0Yndt1n-qsusK15ywBPyPWmhc1nj0suWm4Phc0IHYLn1RvwWD4rHf1PHPawjfdnHD1PWn3rRnYfRmsnj9KnfK95gTqFhdWpyfqnW63rj63P10vniusThqbpyfqnHm0uHdCIZwsrBtEILILQhk9uvqdQhPEUitOIgwVgLPEIgFWuHdVgvPhgvPsI7qBmy-bINqsmsKWThnqnWDLPWD%26tpl%3Dtpl_10085_14394_1%26l%3D1050227251%26attach%3Dlocation%253D%2526linkName%253D%2525E6%2525A0%252587%2525E9%2525A2%252598%2526linkText%253D%2525E6%25258B%252589%2525E5%25258B%2525BE%2525E7%2525BD%252591%2525E5%2525AE%252598%2525E7%2525BD%252591-%2525E4%2525B8%252593%2525E4%2525B8%25259A%2525E7%25259A%252584%2525E4%2525BA%252592%2525E8%252581%252594%2525E7%2525BD%252591%2525E6%25258B%25259B%2525E8%252581%252598%2525E5%2525B9%2525B3%2525E5%25258F%2525B0%25252C%2526xp%253Did%28%252522m5ed412f7%252522%29%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FDIV%25255B1%25255D%25252FH2%25255B1%25255D%25252FA%25255B1%25255D%2526linkType%253D%2526checksum%253D253%26ie%3Dutf-8%26f%3D3%26tn%3D02049043_32_pg%26wd%3D%25E6%258B%2589%25E5%258B%25BE%25E7%25BD%2591%26rqlang%3Dcn%26inputT%3D2026%26prefixsug%3Dlagouwan%26rsp%3D0; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F%3Futm_source%3Dm_cf_cpt_baidu_pc; JSESSIONID=58871A5ADBA698B52DA3421A2DA82999; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1486185699; LGRID=20170204132145-d2295eec-ea99-11e6-8e74-5254005c3644; TG-TRACK-CODE=index_hotjob",
    'Referer': "https://www.lagou.com/?utm_source=m_cf_cpt_baidu_pc",
    'Host': "www.lagou.com"
}


def get_urls_from(channel, i):
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
            for url, j in zip(urls_tag, range(100)):
                url = 'http:' + url.get('href')
                UK = (re.search(r"\d+", url)).group()
                main.Q.put((url, category), block=1)
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
    if(main.Q.empty()):
        time.sleep(4)
        if(main.Q.empty()):
            db.close()
            return 0
    print("当前URL队列总数：", main.Q.qsize())
    queue = main.Q.get()
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
        public_time = time.strftime('%Y-%m-%d', time.localtime(time.time()))
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
    position_description = soup.select(".job_bt > div")[0].text
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
              REPLACE INTO item_info(UK,
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
