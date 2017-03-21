#! encoding:UTF-8
import pyhs2
import pymysql
def hiveConnect():
    db = pyhs2.connect(host='localhost',
                   port=10000,
                   authMechanism="PLAIN",
                   user='root',
                   password='test',
                   )
    return db

def mysqlConnect():
    db = pymysql.connect(host='localhost',
                         user='root',
                         password='test',
                         database='hive_data',
                        )
    return db


def hiveInit(db):
    sql = "CREATE DATABASE IF NOT EXISTS hive_data"  #创建数据库
    cur = db.cursor()
    cur.execute(sql)
    # # 创建数据表

    sql = '''CREATE TABLE IF NOT EXISTS hive_data.data(probe_id varchar(3000),
                          probe_mac varchar(3000),
                          rate int,
                          wssid varchar(3000),
                          wmac varchar(3000),
                          time TIMESTAMP,
                          lat DOUBLE ,
                          lon DOUBLE ,
                          addr varchar(3000),
                          phone_mac varchar(3000),
                          phone_rssi int,
                          phone_range int,
                          phone_tmc varchar(100),
                          tc boolean,
                          ds boolean,
                          essid varchar(3000)
                                        )
          '''
    cur.execute(sql)

def mysqlInit(db):
        sql = "CREATE DATABASE IF NOT EXISTS hive_data"  # 创建数据库
        cur = db.cursor()
        cur.execute(sql)
        # # 创建数据表

        sql = '''CREATE TABLE IF NOT EXISTS hive_data.data(
                              probe_id varchar(3000),
                              probe_mac varchar(3000),
                              rate int,
                              wssid varchar(3000),
                              wmac varchar(3000),
                              time TIMESTAMP,
                              lat DOUBLE ,
                              lon DOUBLE ,
                              addr varchar(3000),
                              phone_mac varchar(3000),
                              phone_rssi int,
                              phone_range int,
                              phone_cssid int,
                              tc boolean,
                              ds boolean,
                              essid varchar(3000)
                                            )
              '''
        cur.execute(sql)
def execute(db,sql):
    cur = db.cursor()
    cur.execute(sql)
    db.commit()
    return cur
