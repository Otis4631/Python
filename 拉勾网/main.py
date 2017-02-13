from channel_extract import channel_urls_list
import spider
import time
from multiprocessing import Pool
from tqdm import tqdm

def get_all_links():
    pool = Pool(processes=3)
    print(len(channel_urls_list))
    for channel, i in tqdm(zip(
            channel_urls_list, range(
            1, len(channel_urls_list) + 1))):
        if i < 247:
            continue
        print("channel-%d 准备开始..." % i)
        try:
            pool.apply_async(spider.get_urls_from, (channel,i))
        except Exception as error:
            print("无法为函数get_item创建子进程错误为： ",error)
    pool.close()
    print("所有频道链接已加入队列.....")

def get_all_item():
    p = Pool()
    while 1:
        if spider.isQempty():
            time.sleep(20)
            if spider.isQempty():
                print("当前URL队列已空，函数即将返回")
                break
        try:
            p.apply_async(spider.get_item_from)
        except Exception as error:
            print("无法为函数get_item创建子进程错误为： ",error)
    p.close()
    p.join()

if __name__ == '__main__':
    start_time = time.clock()
    get_all_links()
    time.sleep(10)
    get_all_item()
    end_time = time.clock()
    ditime = (end_time - start_time) / 60.0
    print('全部链接已获得，用时{:.4f}min'.format(ditime))

