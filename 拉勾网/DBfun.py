import pymysql


def connectDB():

    db = pymysql.connect('localhost', 'root', 'lizheng1997', db="lagouwang",charset='utf8')
    return db


def connectRDB():
    db = pymysql.connect('chinali.win', 'root', 'QNmd4631++',db="lagouwang", charset='utf8')
    return db


def init_db(db):
    # 创建数据库
    with db.cursor() as cursor:
        global db_name
        db_name = 'lagouwang'
        cursor.execute("CREATE DATABASE IF NOT EXISTS %s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci" % db_name)
        db.select_db(db_name)

        # 创建数据表
        table_name1 = 'url_list'
        table_name2 = 'item_info'
        cursor.execute(
            'CREATE TABLE IF NOT EXISTS %s(id int primary key auto_increment, url varchar(255)  ,UK int UNIQUE KEY ,category varchar(255));' %
            table_name1)
        cursor.execute(
            '''
                        CREATE TABLE IF NOT EXISTS %s(
                        id int primary key NOT NULL auto_increment,
                        public_time date,
                        category varchar(30),
                        company_name varchar(30),
                        company_place varchar(255),
                        company_num varchar(30),
                        position_description text,
                        pay varchar(30),
                        requirement varchar(100),
                        UK int  UNIQUE KEY,
                        company_development varchar(10));
                       '''
            % table_name2)


def insert_to_item(sql, db):
    try:
        with db.cursor() as cursor:
            # db.select_db(db_name)
            cursor.execute(sql)
            db.commit()
    except Exception as error:
        print(error)
