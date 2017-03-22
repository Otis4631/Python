import threading
import time
import random
import datetime
import json
import requests

WIFI_PROBE = 1000
WIFI_PROBE_ID = set()
WIFI_AP_SSID = ('hello1', 'hello2', 'hello3')
MAC_TABLE = ['mac' + str(i) for i in range(5000)]
wifi_info = {}


def createData(wifi_info):
    wifi_info['data'] = {
        'mac': random.choice(MAC_TABLE),
        'rssi': random.uniform(-100, 0),
        'range': random.randrange(0, 30),
        'ts': random.choice(WIFI_AP_SSID),
        'tc': random.choice(('Y', 'N')),
        'ds': random.choice(('Y', 'N')),
        'tmc': 'fffffffff',
        'essid': 'ssssssss',
        'time':datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    }
    jsonEncode = json.dumps(wifi_info)
    try:
        requests.post('http://127.0.0.1:5000/post', data={'a':jsonEncode})
        print "111111"
    except Exception, e:
        with open('log.txt', 'a') as fp:
            fp.write(str(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(time.time()))) + '----' + str(e) + '\n')
        print e


def createWifiInfo(wifi_info, id):
    wifi_info['id'] = id
    wifi_info['rate'] = 1
    wifi_info['mmac'] = 'ffffff'
    wifi_info['wssid'] = 'ffffff'
    wifi_info['wmac'] = 'sssssss'
    wifi_info['addr'] = '......'
    wifi_info['lat'] = '30.748093'
    wifi_info['lon'] = '103.973083'


def wifiProbe(id):
    if id not in WIFI_PROBE_ID:
        WIFI_PROBE_ID.add(id)
        createWifiInfo(wifi_info, id)
        createData(wifi_info)
    else:
        createData(wifi_info)


def main():
    while True:
        for i in range(WIFI_PROBE):
            t = threading.Thread(target=wifiProbe, args=(i,))
            t.setDaemon(False)
            t.start()
        t.join()
        time.sleep(3)


probe_info = {
}

if __name__ == '__main__':
    main()