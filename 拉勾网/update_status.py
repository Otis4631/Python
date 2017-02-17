import pymysql
import requests,re
from multiprocessing import Pool
from bs4 import BeautifulSoup

def delete_item(UK):
    db = pymysql.connect('chinali.win', 'root', 'QNmd4631++', db="lagouwang", charset='utf8')
    c = db.cursor()
    sql1 = 'DELETE FROM url_list WHERE UK={}'.format(UK)
    sql2 = 'DELETE FROM item_info WHERE UK={}'.format(UK)
    c.execute(sql1)
    c.execute(sql2)
    db.commit()
    c.close()
    db.close()

def idsa():
    db = pymysql.connect('chinali.win', 'root', 'QNmd4631++', db="lagouwang", charset='utf8')
    j = 0
    c = db.cursor()
    sql_q = "SELECT id from item_info ORDER BY id ASC"
    c.execute(sql_q)
    ids = [id[0] for id in c]
    c.close()
    for id in ids:
        j += 1
        print(id,'---->',j)
        sql_u = "UPDATE item_info set id={} WHERE id={}".format(j,id)
        cuq = db.cursor()
        cuq.execute(sql_u)
        db.commit()
    cuq.close()
    db.close()

def update__():
    db = pymysql.connect('chinali.win', 'root', 'QNmd4631++', db="lagouwang", charset='utf8')
    c = db.cursor()
    sql_url = "select url from url_list "
    c.execute(sql_url)
    urls = [url[0] for url in c]
    i = 0
    for url in urls:
        i+=1
        UK = (re.search(r"\d+", url)).group()
        url = url.replace('www','m')+'?m=1'
        print(url)

        web_data = requests.get(url,)
        soup = BeautifulSoup(web_data.text,'lxml')
        try:
            status = soup.select("div.deliver")[0].text.strip()
        except Exception:
            delete_item(UK)
            continue
        if len(status) == 4:
            status = "正在招聘"
        else:
            status = "已下线"
        cur = db.cursor()
        sql = "update item_info set status ='{}' WHERE UK={}".format(status,UK)
        cur.execute(sql)
        db.commit()
    print(i)
    c.close()
    db.close()

def update_status():
    p = Pool()
    p.apply_async(idsa)
    p.apply_async(update__())
    p.close()
    p.join()
    print('Done!')