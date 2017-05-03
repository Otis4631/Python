#! encoding:UTF-8

# ####################################################################
#   Copyright (C), team BugKiller
#   File name:  DataGatheringServer
#   Author:李政      Version:1.00        Date: 2017-04-12
#
#   Description:    数据采集模块，使用Flask框架采用多线程处理数据源并发，接受Json格式的数据，将数据处理完毕存入mysql数据库。
#   Function List:
#         post()
# #####################################################################

import json
from flask import Flask, request
from Database import DataBase
import datetime

app = Flask(__name__)

BOOL = {'Y': 1, 'N': 0}  # 用于转换WIFI探针中的Bool类型到mysql中可识别的bool类型。

dataKeys = set()
keys = set()

dataKeys.add('ds')      # 手机是否睡眠
dataKeys.add('tc')      # 是否与路由器相连
dataKeys.add('ts')      # 目标ssid，手机链接的WIFI的ssid
dataKeys.add('tmc')     # 目标设备的mac，手机链接WIFI的mac
dataKeys.add('essid')   # 手机连接的ssid

keys.add('wssid')
keys.add('wmac')
keys.add('addr')


def timeChange():

    pass


@app.route('/post', methods=['POST'])
def post():
    """ Function:       post()
        Description:    用于接收来自数据源的Json数据，只接受POST方法。
        Input:          无。
        Return:         :return str: 成功链接提示.
                        :rtype str.
        Others:         无。
    """
    db = DataBase.mysqlConnect()
    jsonEncode = request.form.get('data')
    jsonDecode = json.loads(jsonEncode)


    for key in keys:
        if key not in jsonDecode:
            jsonDecode[key] = 'NULL'

    if not jsonDecode['lon']:
        jsonDecode['lon'] = -1
    if not jsonDecode['lat']:
        jsonDecode['lat'] = -1

    for key in keys:
        if key not in jsonDecode:
            jsonDecode[key] = 'NULL'

    for item in jsonDecode['data']:
        for key in dataKeys:
            if key not in item:
                item[key] = 'NULL'
        if item['ds'] != 'NULL':
            item['ds'] = BOOL[item['ds']]
        else:
            item['ds'] = -1
        if item['tc'] != 'NULL':
            item['tc'] = BOOL[item['tc']]
        else:
            item['tc'] = -1
    # jsonDecode['data']['ds'] = BOOL[int(jsonDecode['data']['ds'])]
    # jsonDecode['data']['tc'] = BOOL[int(jsonDecode['data']['tc'])]
    #
        sql = """
                 INSERT INTO data
                         (probe_id,probe_mac,rate,wssid,wmac,time,lat,lon,
                         addr,phone_mac,phone_rssi,phone_range,phone_tmc, tc,ds,essid,ts)
                   VALUES('{}','{}',{},'{}','{}','{}',{},{},'{}','{}',{},{},'{}',{},{},"{}","{}")
                 """.format(
            jsonDecode['id'],
            jsonDecode['mmac'],
            jsonDecode['rate'],
            jsonDecode['wssid'],
            jsonDecode['wmac'],
            datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
            jsonDecode['lat'],
            jsonDecode['lon'],
            jsonDecode['addr'],
            item['mac'],
            item['rssi'],
            item['range'],
            item['tmc'],
            item['tc'],
            item['ds'],
            item['essid'],
            item['ts'])
        try:
            DataBase.mysqlExecute(db, sql)
        except Exception as error:
            print sql
            print "数据插入异常：" + str(error)
    print str(len(jsonDecode['data'])) + "条数据已存入数据库"
    return 'welcome'


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', threaded=True)
