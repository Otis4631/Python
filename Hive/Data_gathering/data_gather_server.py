from flask import Flask, request
import json
import HiveConnection
app = Flask(__name__)



@app.route('/post', methods=['POST'])
def post():
    db = HiveConnection.mysqlConnect()
    cursor = db.cursor()
    jsonEncode = request.form.get('a')
    jsonDecode = json.loads(jsonEncode)
    print jsonDecode
    sql = """
          INSERT INTO data
                  (probe_id,probe_mac,rate,wssid,wmac,time,lat,lon,addr,phone_mac,phone_rssi,phone_range,phone_cssid, ts,ds,essid)
            VALUES('{}','{}',{},'{}','{}','{}',{},{},'{}','{}',{},{},'{}',{},{},"{}")
          """.format(jsonDecode['id'],jsonDecode['mmac'],jsonDecode['rate'],jsonDecode['wssid'],jsonDecode['wmac'],
                     jsonDecode['data']['time'],jsonDecode['lat'],jsonDecode['lon'],jsonDecode['addr'],jsonDecode['data']['mac'],
                     jsonDecode['data']['range'],jsonDecode['data']['ts'],jsonDecode['data']['ds'],jsonDecode['data']['essid'])
    HiveConnection.execute(db,sql)
    # {"addr": "......", "lon": "103.973083", "wssid": "ffffff", "rate": 1, "lat": "30.748093", "mmac": "ffffff",
    #  "data": {"mac": "mac4203", "tmc": "fffffffff", "essid": "ssssssss", "tc": true, "time": "2017-03-17 20:05:24",
    #           "rssi": -97.17479516331206, "range": 26, "ds": true, "ts": "hello2"}, "id": 0}





    return 'welcome'



if __name__ == '__main__':
    app.run(debug=True)

