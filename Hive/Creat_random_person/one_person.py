import requests
import threading,os

def post():
    data = {'name': 'zzzlssd', 'age': 'shjshj'}
    requests.post('http://127.0.0.1:5000/post', data=data)


while 1:
   for i in range(1000):
        t = threading.Thread(target=post)
        t.setDaemon(True)
        t.start()
   t.join()
