import requests

url = "http://m.lagou.com/jobs/2475737.html?m=1"
web = requests.get(url)
print(web.status_code)
print(web.text)