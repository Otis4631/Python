import DataBaseConnection
import os
db = DataBaseConnection.mysqlConnect()
#
DataBaseConnection.mysqlInit(db)


sql = "select * from data where time=2017-04-12"
sql2 = "describe data"
sql1 = 'select * from metadata  WHERE probe_id=1 limit 1'
cur = DataBaseConnection.hiveExecute(db, sql2)
# print cur.fetch()
# import time
# print time.time()
# str(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time())))