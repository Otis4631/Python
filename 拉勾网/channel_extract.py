from bs4 import BeautifulSoup
import requests
START_URL = "https://www.lagou.com/"
channel_urls_list = []

# def get_channel_urls():
#     start_web_data = requests.get(START_URL)
#     soup = BeautifulSoup(start_web_data.text, 'lxml')
#     channel_urls = soup.select("div .menu_sub > dl > dd > a")
#     for p in channel_urls:
#         channel_urls_list.append('http://' + str(p.get('href')[2:]))

def get_channel_urls():
    start_web_data = requests.get(START_URL)
    soup = BeautifulSoup(start_web_data.text, 'lxml')
    channel_urls = soup.select("div .menu_sub > dl ")
    for tag in channel_urls:
        cate = tag.text.strip().split('\n')[0]
        urls = tag.dd.findAll('a')
        for url in urls:
            channel_urls_list.append((cate, 'http://' + str(url.get('href')[2:])))
        break

get_channel_urls()
print("共有%d个频道" % len(channel_urls_list))