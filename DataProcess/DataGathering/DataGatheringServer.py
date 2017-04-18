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
from DataProcess.Database import DataBaseConnection

app = Flask(__name__)

BOOL = {'Y': 1, 'N': 0}  # 用于转换WIFI探针中的Bool类型到mysql中可识别的bool类型。


@app.route('/post', methods=['POST'])
def post():
    """ Function:       post()
        Description:    用于接收来自数据源的Json数据，只接受POST方法。
        Input:          无。
        Return:         :return str: 成功链接提示.
                        :rtype str.
        Others:         无。
    """
    db = DataBaseConnection.mysqlConnect()
    jsonEncode = str(request.form.get('a'))
    jsonDecode = json.loads(jsonEncode)
    jsonDecode['data']['ds'] = BOOL[jsonDecode['data']['ds']]
    jsonDecode['data']['tc'] = BOOL[jsonDecode['data']['tc']]

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
        jsonDecode['data']['time'],
        jsonDecode['lat'],
        jsonDecode['lon'],
        jsonDecode['addr'],
        jsonDecode['data']['mac'],
        jsonDecode['data']['rssi'],
        jsonDecode['data']['range'],
        jsonDecode['data']['tmc'],
        jsonDecode['data']['tc'],
        jsonDecode['data']['ds'],
        jsonDecode['data']['essid'],
        jsonDecode['data']['ts'])
    try:
        DataBaseConnection.execute(db, sql)
    except Exception as error:
        print "数据插入异常：" + error

    return 'welcome'


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', threaded=True)
