from channel_extract import channel_urls_list
import update_spider

def update_url_list():
    for channel, i in (zip(
            channel_urls_list, range(
                1, len(channel_urls_list) + 1))):
        update_spider.get_urls_from(channel, i)




update_url_list()