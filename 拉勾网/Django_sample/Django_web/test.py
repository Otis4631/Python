import pymysql
db = pymysql.connect('chinali.win', 'root', 'QNmd4631++',db="lagouwang", charset='utf8')

sql = "select category,position_description,pay,UK,requirement from item_info order by UK asc limit 2000 "

c = db.cursor()
c.execute(sql)
res = c
links = ['http://https://www.lagou.com/jobs/{}.html'.format(link[3]) for link in res]
print(links)