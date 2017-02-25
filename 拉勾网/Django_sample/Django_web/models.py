from django.db import models

class item_info(models.Model):
    UK = models.CharField(max_length=255)
    public_time = models.DateField(max_length=255)
    category = models.CharField(max_length=255)
    company_name = models.CharField(max_length=255)
    company_place = models.CharField(max_length=255)
    company_num = models.CharField(max_length=255)
    position_description = models.TextField(max_length=50)
    pay = models.CharField(max_length=255)
    requirement = models.CharField(max_length=255)
    company_development = models.CharField(max_length=255)
    link = models.CharField(max_length=50)
    Mcategory = models.CharField(max_length=10)

    def __unicode__(self):
        return self.category

    class Meta:
        db_table = 'item_info'


class url_list(models.Model):
    url = models.CharField(max_length=255)
    category = models.CharField(max_length=10)
    Mcategory = models.CharField(max_length=10)

    def __unicode__(self):
        return self.category

    class Meta:
        db_table = 'url_list'
    # UK,
    # public_time,
    # category,
    # company_name,
    # company_place,
    # company_num,
    # position_description,
    # pay,
    # requirement,
    # company_development