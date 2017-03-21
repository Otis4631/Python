from flask import Flask, request
import json
import HiveConnection
app = Flask(__name__)

BOOL = {'Y':1,'N':0}

@app.route('/post', methods=['POST'])
def post():
    db = HiveConnection.mysqlConnect()
    cursor = db.cursor()
    jsonEncode = str(request.form.get('a'))
    jsonDecode = json.loads(jsonEncode)
    jsonDecode['data']['ds'] =BOOL[jsonDecode['data']['ds']]
    jsonDecode['data']['tc'] = BOOL[jsonDecode['data']['tc']]
    # print jsonDecode
    # jsonDecode = {u'addr': u'......', u'lon': u'103.973083', u'wmac': u'sssssss', u'wssid': u'ffffff', u'rate': 1, u'lat': u'30.748093', u'mmac': u'ffffff', u'data': {u'ts': u'hello2', u'range': 27, u'ds': True, u'mac': u'mac3048', u'tmc': u'fffffffff', u'essid': u'ssssssss', u'time': u'2017-03-21 19:17:54', u'rssi': -20.34902054720321, u'tc': True}, u'id': 0}

    sql = """
             INSERT INTO data
                     (probe_id,probe_mac,rate,wssid,wmac,time,lat,lon,
                     addr,phone_mac,phone_rssi,phone_range,phone_tmc, tc,ds,essid,ts)
               VALUES('{}','{}',{},'{}','{}','{}',{},{},'{}','{}',{},{},'{}',{},{},"{}","{}")
             """.format(jsonDecode['id'], jsonDecode['mmac'], jsonDecode['rate'], jsonDecode['wssid'],
                        jsonDecode['wmac'],
                        jsonDecode['data']['time'], jsonDecode['lat'], jsonDecode['lon'], jsonDecode['addr'],
                        jsonDecode['data']['mac'], jsonDecode['data']['rssi'],
                        jsonDecode['data']['range'], jsonDecode['data']['tmc'], jsonDecode['data']['tc'],
                        jsonDecode['data']['ds'],
                        jsonDecode['data']['essid'], jsonDecode['data']['ts'])

    print sql
    HiveConnection.execute(db,sql)

    return 'welcome'


if __name__ == '__main__':
    app.run(debug=True)

