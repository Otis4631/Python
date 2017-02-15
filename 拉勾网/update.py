from channel_extract import channel_urls_list
import update_spider
import time
from multiprocessing import Pool
def update_url_list():
    start_time = time.clock()
    P = Pool()
    for channel, i in (zip(
            channel_urls_list, range(
                1, len(channel_urls_list) + 1))):

        P.apply_async(func=update_spider.get_urls_from,args=(channel,i))
    P.close()
    P.join()
    end_time = time.clock()
    ditime = (end_time - start_time) / 60.0
    print('全部链接已获得，用时{:.4f}min'.format(ditime))

if __name__ == "__main__":
    update_url_list()

