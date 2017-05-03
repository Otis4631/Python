#! encoding:UTF-8

# ####################################################################
#   Copyright (C), team BugKiller
#   File name:  DataBase
#   Author:李政      Version:1.00        Date: 2017-04-10
#
#   Description:    数据库操作相关函数，包括mysql和hive数据库的链接，sql语句的执行函数以及数据库的初始化。
#                   其他与数据库操作相关的方法均调用此模块。
#   Function List:
#         hiveConnect()
#         mysqlConnect()
#         hiveInit()
#         mysqlInit()
#         hiveExecute()
#         mysqlExecute()
# #####################################################################
import pyhs2
import pymysql


def hiveConnect():

    """ Function:       hiveConnect()
        Description:    hive数据库链接函数。
        Input:          无。
        Return:         数据库连接对象。
        Others:         无。
    """
    try:
        db = pyhs2.connect(host='localhost',
                           port=10000,
                           authMechanism="PLAIN",
                           user='root',
                           password='test',
                           database='hive_data'
                           )
    except Exception as e:
        print "hive数据库链接失败，请检查hiveserver2是否开启。"
        return None
    return db


def mysqlConnect():

    """ Function:       mysqlConnect()
        Description:    mysql数据库链接函数。
        Input:          无。
        Return:         数据库连接对象。
        Others:         无。
    """

    try:
        db = pymysql.connect(host='localhost',
                             user='root',
                             password='test',
                             database='hive_data',
                             )
    except Exception as e:
        print "mysql数据库链接失败！"
    return db


def hiveInit(db):

    """ Function:       hiveInit()
        Description:    hive数据库初始化函数，用于创建数据库与数据表。
        Input:          数据库连接对象。
        Return:         无。
        Others:         无。
    """
    sql = "CREATE DATABASE IF NOT EXISTS hive_data"  # 创建数据库
    hiveExecute(db, sql)

    # 创建初始数据表
    sql = '''CREATE TABLE IF NOT EXISTS hive_data.data(
                          id int,
                          probe_id varchar(3000),
                          probe_mac varchar(3000),
                          rate int,
                          wssid varchar(3000),
                          wmac varchar(3000),

                          lat DOUBLE ,
                          lon DOUBLE ,
                          addr varchar(3000),
                          phone_mac varchar(3000),
                          phone_rssi int,
                          phone_range int,
                          phone_tmc varchar(100),
                          tc boolean,
                          ds boolean,
                          ts VARCHAR(50),
                          essid varchar(3000)
                          )
              PARTITIONED BY (time DATE)
              row format delimited
              fields terminated by ','
              lines terminated by '\n'
          '''
    hiveExecute(db, sql)


def mysqlInit(db):

    """ Function:       mysqlInit()
        Description:    mysql数据库初始化函数，用于创建数据库与数据表。
        Table Accessed: hive_data.data, hive_data.inshop。
        Table Updated:  hive_data.data, hive_data.inshop。
        Input:          数据库链接对象。
        Return:         无。
        Others:         无。
    """
    sql = "CREATE DATABASE IF NOT EXISTS hive_data"  # 创建数据库
    mysqlExecute(db, sql)
    # 创建初始数据表

    sql = '''CREATE TABLE  hive_data.data(
                          id int PRIMARY KEY NOT NULL auto_increment,
                          probe_id varchar(3000),
                          probe_mac varchar(3000),
                          rate int,
                          wssid varchar(3000),
                          wmac varchar(3000),
                          lat DOUBLE DEFAULT 0,
                          lon DOUBLE DEFAULT 0,
                          addr varchar(3000),
                          phone_mac varchar(3000),
                          phone_rssi int,
                          phone_range int,
                          phone_tmc varchar(100),
                          tc boolean,
                          ds boolean,
                          ts VARCHAR(50),
                          essid varchar(3000),
                          time TIMESTAMP)
              '''
    mysqlExecute(db, sql)

    sql = '''
                CREATE TABLE hive_data.entershop(
                  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                  mac VARCHAR (30),
                  time TIMESTAMP,
                  standingtime time,
                )
              '''
    mysqlExecute(db,sql)

def mysqlExecute(db, sql):

    """ Function:       mysqlExecute()
        Description:    本函数用于在mysql数据库中执行SQL语句。
        Input:          :param db: 数据库链接对象。
                        :type db: mysql connect object.

                        :param sql: SQL语句。
                        :type sql: str.
        Return:         :return cur: object you use to interact with the database.
                        :rtype cur: object.
        Others:         无。
    """
    cur = db.cursor()
    cur.execute(sql)
    db.commit()
    return cur


def hiveExecute(db, sql):
    """ Function:       mysqlExecute()
        Description:    本函数用于在hive数据库中执行SQL语句。
        Input:          :param db: 数据库链接对象。
                        :type db: hive connect object.

                        :param sql: SQL语句。
                        :type sql: str.

        Return:         :return cur: object you use to interact with the database.
                        :rtype cur: object.
        Others:         无。
    """
    cur = db.cursor()
    cur.execute(sql)
    return cur
