import time,os
while 1:
    with open('loop.log','w+') as fp:
        fp.write(str(time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))))
    os.system('python3 update.py > update.log')
    time.sleep(2 * 24 * 60 * 60 * 60)