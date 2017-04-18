#! encoding:UTF-8

# ####################################################################
#   Copyright (C), team BugKiller
#   File name:  DataImport
#   Author:李政      Version:1.00        Date: 2017-04-14
#
#   Description:    数据导入模块，用于将mysql数据库中一天的数据导入到hive数据库对应日期分区下存储。
#   Function List:
#         allImport()
#         getTime()
#         addImport()
# #####################################################################
import os
import time


# 全量导入
def allImport():
    """ Function:       allImport()
        Description:    全量导入函数，用于第一次或者hive数据库中的数据遭受损害时将mysql中所有的数据导入到hive数据库。
        Input:          无。
        Return:         无。
        Others:         需安装apache sqoop工具。
    """
    sqoopCmd = "sqoop import -m 1 --connect jdbc:mysql://localhost:3306/hive_data --username root --password test --table data --hive-import --hive-database hive_data --create-hive-table --hive-table data"
    os.system(sqoopCmd)


# 增量导入
def getTime(delay=0, advance=0):
    """ Function:       getTime()
        Description:    获取当前日期的函数。
        Input:          :param delay: 用于调整得到所需时间，非0则返回数据在当前时间之前，单位为秒。
                        :type delay int.

                        :param advance: 用于调整得到所需时间，非0则返回数据在当前时间之后，单位为秒。
                        :type advance int.


        Return:         :return 返回当前时间，格式为 YYYY-MM-DD HH:MM:SS。
                        :rtype str.
        Others:         需安装apache sqoop工具。
    """
    return str(
        time.strftime(
            '%Y-%m-%d',
            time.localtime(
                time.time() -
                delay +
                advance)))


def addImport():
    """ Function:       addImport()
        Description:    增量导入函数，用于每天将数据库中的数据增量导入到hive数据库对应日期下的分区。
        Input:          无。
        Return:         无。
        Others:         需安装apache sqoop工具，需hadoop用户创建目录权限。
    """
    time = getTime()
    sqoopCmd = '''
        /root/sqoop/bin/sqoop import --connect jdbc:mysql://localhost:3306/hive_data --username root --password test --table data --where " time>='{}' AND time<'{}' "   --split-by id -m 1 --target-dir /temp/hive/{}
                '''.format(time, getTime(advance=24 * 3600), time)
    hiveCmd = '''
        /root/hive/bin/hive -e "ALTER TABLE hive_data.data ADD PARTITION(time='{}') location '/temp/hive/{}/';"
            '''.format(time, time)
    chmodCmd = "/root/hadoop/bin/hadoop fs -chmod -R 777 /temp/"  # 导入hive可能出现权限不足，需对临时目录降权。

    os.system(sqoopCmd)
    os.system(chmodCmd)
    os.system(hiveCmd)


addImport()
