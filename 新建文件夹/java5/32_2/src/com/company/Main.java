package com.company;

import java.util.*;

class CalendarBean{
    String[] day;//日期数组
    int year, month;
    public CalendarBean(){} //构造函数
    public CalendarBean(int year, int month){//含参构造函数，初始化年月
        this.year = year;
        this.month = month;
    }
    public void set(int year, int month){//设置年月
        this.year = year;
        this.month = month;
    }
    public int getYear(){//获取年份信息
        return year;
    }
    public int getMonth(){//获取月份信息
        return month;
    }
    public String [] getCalendar(){ //格式化日历天数字符串
        String[] a = new String[42]; //day数组
        Calendar 日历 = Calendar.getInstance();//获取一个 Calendar 对象，此对象已由当前日
        //期时间初始化，即默认代表当前时间
        日历.set(year, month-1, 1);//设置年月日
        int 星期几 = 日历.get(Calendar.DAY_OF_WEEK)-1;//获取第一天是星期几
        int day = 0;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            day = 31;
        if(month==4||month==6||month==9||month==11)
            day = 30;
        if(month==2){
            if((year%4==0)&&(year%100!=0)||(year%400==0))//判断是否为闰年
                day = 29;
            else
                day = 28;
        }
        for(int i=0; i<星期几; i++){//用于格式化
            a[i] = " ";
        }
        for(int i=星期几,n=1;i<星期几+day;i++){
            a[i] = String.valueOf(n); //整数转化成字符串
            n++;
        }
        for(int i = 星期几+day; i<a.length; i++)//用于格式化
            a[i] = " ";
        return a;
    }
}

public class Main{
    public static void main(String args[]){
        CalendarBean cb = new CalendarBean(2017,4);//当前年月
        String a[] = cb.getCalendar();
        System.out.println("\t"+cb.getYear()+"年"+cb.getMonth()+"月 日 历");
        char [] str = "日一二三四五六".toCharArray();
        for(char c:str){
            System.out.printf("%3c", c);
        }
        for(int i=0; i<a.length; i++){
            if(i%7==0){
                System.out.println("");//一星期一行
            }
            System.out.printf("%4s", a[i]);
        }
    }
}