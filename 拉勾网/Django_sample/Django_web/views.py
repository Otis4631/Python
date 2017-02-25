from django.shortcuts import render
from Django_web.models import item_info,url_list
from django.db.models import Q
import json
def index(request):
    public_time = item_info.objects.all().order_by('-public_time')[:1]
    ONE_PAGE_OF_DATA = 5
    try:
        curPage = int(request.GET.get('curPage'))
        pageType = str(request.GET.get('pageType'))
        allPage = int(request.GET.get('allPage'))
        keyWord = str(request.GET.get('kw',''))
    except Exception:
        curPage = 1
        allPage = 1
        pageType = ''
        keyWord = ''
        # 判断点击了【下一页】还是【上一页】
    if request.method == 'POST':
        keyWord = request.POST.get('kw',None)
        keyWord = str(keyWord).replace(' ','')
        curPage = 1
        allPage = 1
    if pageType == 'pageDown':
        curPage += 1
    elif pageType == 'pageUp':
        curPage -= 1
    startPos = (curPage - 1) * ONE_PAGE_OF_DATA
    endPos = startPos + ONE_PAGE_OF_DATA
    try:
        q1 = Q(category__icontains=keyWord)
        q2 = Q(Mcategory__icontains=keyWord)
        q3 = Q(company_place__icontains=keyWord)
        q4 = Q(UK=keyWord)
        query =q1 | q2 | q3 | q4
        posts = item_info.objects.filter(query)[startPos:endPos]
        allItemCount =(item_info.objects.filter(query).count())
    except UnboundLocalError as e:
        print(e)
        posts = item_info.objects.all()[startPos:endPos]
        allItemCount = item_info.objects.all().count()
    if curPage == 1 and allPage == 1:  # 标记1
        allPage = allItemCount // ONE_PAGE_OF_DATA
        remainPost = allItemCount % ONE_PAGE_OF_DATA
        if remainPost > 0:
            allPage += 1
    context = {'items': posts,
               'allPage': allPage,
               'curPage': curPage,
               'allItem':allItemCount,
               'public_time':public_time[0].public_time,
               'kw':keyWord
               }
    return render(request, "index_data.html", context)


def chart(request):
    Mdata = []
    cdata = []
    Mcategory = list(url_list.objects.values_list('Mcategory', flat=True).distinct())
    total = url_list.objects.count()
    for item in Mcategory:
        data = []
        y = url_list.objects.filter(Mcategory=item).count()
        temp_dict = {
            'name':item,
            'y':y,
            'drilldown':item,
            'per': (y/total)
        }
        Mdata.append(temp_dict)
        category = url_list.objects.filter(Mcategory=item).values_list('category',flat=True).distinct()
        total = url_list.objects.filter(Mcategory=item).count()
        for cate in category:
            data.append([cate,url_list.objects.filter(Mcategory=item).filter(category=cate).count()])
            temp_dict = {
                'data':data,
                'name': item,
                'id': item,
            }
            cdata.append(temp_dict)

    context = {
        'Mdata':json.dumps(Mdata,ensure_ascii=False),
        'cdata':json.dumps(cdata,ensure_ascii=False)
    }
    return render(request,'charts.html',context)