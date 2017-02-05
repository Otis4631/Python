from bs4 import BeautifulSoup
import requests
START_URL = "https://www.lagou.com/"
channel_urls_list = []

def get_channel_urls():
    start_web_data = requests.get(START_URL)
    soup = BeautifulSoup(start_web_data.text, 'lxml')
    channel_urls = soup.select("div .menu_sub > dl > dd > a")
    for p in channel_urls:
        channel_urls_list.append('http://' + str(p.get('href')[2:]))
get_channel_urls()
