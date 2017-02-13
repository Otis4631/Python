from django.shortcuts import render
import pymysql
from django.core.paginator import Paginator
db = pymysql.connect('123.207.162.101', 'root', 'QNmd4631++',db="lagouwang", charset='utf8')


def execute_sql(sql):
    cur = db.cursor()
    cur.execute(sql)
    res = cur
    cur.close()
    return res

def get_all_count():
    sql = "select count(*) from item_info "
    re = [res[0] for res in execute_sql(sql)]
    return re[0]
def get_all_items():
    sql = "select category,position_description,pay,UK,requirement from item_info order by UK asc limit 2000 "
    re = [res for res in execute_sql(sql)]
    return re

def index(request):
    limit = 5
    res = list(get_all_items())
    Res = [list(i) for i in res]
    links =['https://www.lagou.com/jobs/{}.html'.format(link[3]) for link in res]
    for link,i in zip(links,range(3000)):
        Res[i][3] = link
    paginator = Paginator(Res,limit)
    page = request.GET.get('page',1)
    load = paginator.page(page)

    context = {
        'count_all' : get_all_count(),
        'showing_count':len(res),
        'items' : load,
        'links':links
        # 'category':res
        # 'des':
        # 'pay':
        # 'require':



    }
    # (1, '正在招聘', datetime.date(2017, 2, 3), 'Java', 'STW', '南京-栖霞区-元化路8号1栋协同创新大厦405', '50-150人',
    # '5k-10k ', '经验1-3年 /本科及以上 /全职', 2742428, '未融资')
    return render(request, 'index_data.html',context)
# Create your views here.
