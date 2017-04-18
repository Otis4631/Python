#! encoding:UTF-8

import os
import time

#全量导入
def allImport():
    sqoopCmd = "sqoop import -m 1 --connect jdbc:mysql://localhost:3306/hive_data --username root --password test --table data --hive-import --hive-database hive_data --create-hive-table --hive-table data"
    os.system(sqoopCmd)


#增量导入
def getTime(delay=0, advance=0):
    return str(time.strftime('%Y-%m-%d', time.localtime(time.time() - delay + advance)))


def addImport():
    time = getTime()
    sqoopCmd = '''
        /root/sqoop/bin/sqoop import --connect jdbc:mysql://localhost:3306/hive_data --username root --password test --table data --where " time>='{}' AND time<='{}' "   --split-by id -m 1 --target-dir /temp/hive/{}
                '''.format(time, getTime(advance=24 * 3600), time)
    hiveCmd = '''
        /root/hive/bin/hive -e "ALTER TABLE hive_data.data ADD PARTITION(time='{}') location '/temp/hive/{}/';"
            '''.format(time, time)
    chmodCmd = "/root/hadoop/bin/hadoop fs -chmod -R 777 /temp/"
    os.system(sqoopCmd)
    os.system(chmodCmd)
    os.system(hiveCmd)


addImport()