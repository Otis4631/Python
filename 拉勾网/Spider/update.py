from channel_extract import channel_urls_list
import update_spider
import time
import DBfun
from multiprocessing import Pool

db = DBfun.connectRDB()


# 更新链接表
def update_url_list():
    start_time = time.clock()
    P = Pool()
    for channel, i in (zip(channel_urls_list, range(1, len(channel_urls_list) + 1))):
        P.apply_async(func=update_spider.get_urls_from,args=(channel,i))
    P.close()
    P.join()
    end_time = time.clock()
    ditime = (end_time - start_time) / 60.0
    print('全部链接已获得，用时{:.4f}min'.format(ditime))


# 同步两张表中的信息
def sync_table():
    p = Pool()
    sql = "SELECT * FROM url_list WHERE  UK  NOT  IN  ( SELECT UK FROM item_info)"
    cur = db.cursor()
    cur.execute(sql)
    print("将有%d条数据被更新" % len(cur._rows))
    links = [(link[1],link[3],link[4]) for link in cur]
    for link in links:
        p.apply_async(func=update_spider.get_item_from,args=(link,))
    p.close()
    p.join()
    print("信息同步完毕")
    cur.close()


# 删除已下线的信息
def del_offline():
    sql = "SELECT UK FROM item_info WHERE status = '已下线'"
    cur = db.cursor()
    cur.execute(sql)
    print("共",len(cur._rows),"个信息将被删除")
    for UK in cur:
        sql_d = "DELETE FROM item_info  WHERE UK = {}".format(UK[0])
        sql_l = "DELETE FROM url_list  WHERE UK = {}".format(UK[0])
        c = db.cursor()
        c.execute(sql_d)
        c.execute(sql_l)
        print("UK: %d 已经删除" % UK[0])


def fix():
    sql = "SELECT * FROM url_list WHERE ISNULL(item_info.public_time)"
    cur = db.cursor()
    cur.execute(sql)
    print("共", len(cur), "个信息将被修复")
    links = [(link[1],link[3],link[4]) for link in cur._rows]
    update_spider.get_item_from(links)

if __name__ == "__main__":
    from update_status import update_status
    import os
    start = time.clock()
    # os.system('cp /var/lib/mysql/lagouwang/* /root/mysqlbak/lagouwang')
    # with open('/root/mysqlbak/lagouwang/bak.log','w+') as fp:
    #     fp.write(str(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time()))))
    # print('数据库备份完毕')
    # update_status()
    # print('状态更新完成')
    update_url_list()
    print('链接表更新完成，准备删除已下线信息...')
    del_offline()
    print('已删除下线信息，准备同步数据表...')
    sync_table()
    print('数据表同步完成，准备修复数据表...')
    fix()
    print('修复完成...')
    db.close()
    end = time.clock()
    ditime = (end - start)
    print('全部信息已更新，用时{:.4f}min'.format(ditime))
