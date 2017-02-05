# -*- coding:utf-8 -*-
import requests
import os
import re
import urllib
import sys
import socket
from bs4 import BeautifulSoup


def press_any_key_exit(msg):
    import termios

    fd = sys.stdin.fileno()  # 获取标准输入的描述符
    old_ttyinfo = termios.tcgetattr(fd)  # 获取标准输入(终端)的设置
    new_ttyinfo = old_ttyinfo[:]  # 配置终端
    new_ttyinfo[3] &= ~termios.ICANON  # 使用非规范模式(索引3是c_lflag 也就是本地模式)
    new_ttyinfo[3] &= ~termios.ECHO  # 关闭回显(输入不会被显示)
    sys.stdout.write(msg)  # 输出信息
    sys.stdout.flush()
    termios.tcsetattr(fd, termios.TCSANOW, new_ttyinfo)  # 使设置生效
    os.read(fd, 7)  # 从终端读取
    termios.tcsetattr(fd, termios.TCSANOW, old_ttyinfo)  # 还原终端设置


def report(count, blocksize, totalsize):
    global percent
    percent = int(count * blocksize * 100 / totalsize)
    if percent > 100:
        percent = 100
    sys.stdout.write("\r正在下载：%d%%/100%%" % percent)
    sys.stdout.flush()


def get_pic():
    global percent
    global url, urls, urls_name
    for s_url, url_name, k in zip(urls, urls_name, range(1, 50)):
        os.system('clear')
        print('\n\n网页%d正在尝试下载' % k)
        filepath = 'dir/' + url_name + '/'
        try:
            web_data = requests.get(s_url, timeout=None)
        except Exception as e:
            print(e, "\n网页%d链接失败!" % k, end='\n')
            press_any_key_exit("按任意键继续...\n")
            continue
        else:
            web_data.encoding = 'ANSI'
            soup = BeautifulSoup(web_data.text, 'lxml')
            url_imgs = soup.select('img[border="0"] ')
            count_error = 0
            link_error = []
            count_ok = 0
            for url_img, i in zip(url_imgs, range(1, 99)):
                img_link = url_img.get('src')
                match = re.search('jpg', img_link)
                if match:
                    nomatch = re.search('发帖教程', url_name)
                    if nomatch:
                        continue
                    else:
                        imgname = img_link[-10:]
                        if not os.path.exists(filepath):
                            os.makedirs(filepath)
                        else:
                            if not os.path.exists(filepath + imgname):

                                # -------------- 直接下载，会被 403:Forbidden. You can build an opener.
                                opener = urllib.request.build_opener()
                                opener.addheaders = [
                                    ('User-Agent',
                                     'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)'
                                     ' Chrome/36.0.1941.0 Safari/537.36')]
                                urllib.request.install_opener(opener)
                                try:
                                    urllib.request.urlretrieve(
                                        img_link, filepath + imgname, report)
                                    count_ok += 1
                                except urllib.request.ContentTooShortError:
                                        print('Network conditions is not good.Reloading.')
                                        urllib.request.urlretrieve(
                                            img_link, filepath + imgname, report)
                                except Exception as e:
                                    print(e)
                                    count_error += 1
                                    link_error.append(img_link)
                                    if os.path.exists(filepath+imgname):
                                        if percent < 50:
                                            os.remove(filepath + imgname)
                                            print('不完整图像已移除')
                                        else:
                                            print(percent, "图像比较完整", end="\t\t")

                                    continue
                                else:
                                    print("图片%d下载完成" % i)
                                    count_ok += 1
                            else:
                                print("图片已存在!")
                                continue
        print("网页%d下载完成 " % k)
        print('############report#############')
        print("共下载%d个图片" % count_ok)
        print("共%d个图片下载失败,链接为：" % count_error)
        for link in link_error:
            print(link)
        press_any_key_exit("按任意键继续...\n")



def findurl(soup):
    global url, urls, urls_name
    urls_name = []
    urls = []
    for child in soup.select('tr[class="tr3 t_one"]'):
        try:
            match = (
                re.search(
                    "html", str(
                        child.td.next_sibling.h3.a['href'])))
            if match:
                urls.append(url + str(child.td.next_sibling.h3.a['href']))
                urls_name.append(str(child.td.next_sibling.h3.a.string))
        except AttributeError:
            continue
if __name__ == '__main__':
    socket.setdefaulttimeout(30)
    global url, urls, urls_name  # 声明全局变量
    url = 'http://x3.1024lualu.net/pw/'
    for i in range(1, 730):
        try:
            web_data = requests.get(
                url + 'thread.php?fid=15&page=' + str(i), timeout=5)
        except Exception as error:
            print("first web %d connect error！" % i)
            print(error)
            press_any_key_exit("按任意键继续...")
            continue
        else:
            print('web_source_%d got' % i)
            web_data.encoding = 'ANSI'
            soup = BeautifulSoup(web_data.text, 'html.parser')
            findurl(soup)
            get_pic()
            print("img of page%d got" % i)
