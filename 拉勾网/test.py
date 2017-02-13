import pymysql
import time

import sys
temp = 0
print(sys.path)
while True:
    db = pymysql.connect(
        'chinali.win',
        'root',
        'QNmd4631++',
        db="lagouwang",
        charset='utf8')
    c = db.cursor()
    c.execute("select count(*) from url_list")
    for i in c:
        print("url_list: %d" % i[0])
    c.execute("select count(*) from item_info")
    for i in c:
        print("item_info: %d" % i[0])
        change_data = i[0] - temp
    print(change_data)
    temp = i[0]
    c.close()
    time.sleep(10)
    db.close()