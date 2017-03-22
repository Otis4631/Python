from flask import Flask, request
import json
import HiveConnection
app = Flask(__name__)

BOOL = {'Y': 1, 'N': 0}



@app.route('/post', methods=['POST'])
def post():
    db = HiveConnection.mysqlConnect()
    jsonEncode = str(request.form.get('a'))
    jsonDecode = json.loads(jsonEncode)
    jsonDecode['data']['ds'] =BOOL[jsonDecode['data']['ds']]
    jsonDecode['data']['tc'] = BOOL[jsonDecode['data']['tc']]

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

    HiveConnection.execute(db,sql)

    return 'welcome'


if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0',threaded=True)

