package com.company;

import java.util.Scanner;

public class Main{

    private static int year;
    private static int month;
    private static int day;
    private static boolean flag;
    private static int count;//当前月份的天数

    public static void main(String[] args) {


        if(!getInput()) return;
        if(!judgeData()) return;
        int a = getData();
        System.out.println("日   一   二   三   四   五   六");
        int j=0;
        while(a-- > 0){ System.out.print("    "); j++;}
        for(int i=1;i <= count; i++)
        {
            if(j%7==0)System.out.println("\n");
            j++;
            System.out.print(String.format("%4d",i));
            if(day==i)System.out.print("*");
        }

    }



    private static boolean judgeData() {

        flag=false;// false表示平年，反之
        if(year%100==0) flag=true;
        else if(year%4==0) flag=true;
        if(year<=0){
            System.out.println("年份不能小于等于0");
            return false;
        }
        if(month<=0 || month>12){
            System.out.println("检查月份的范围");
            return false;
        }
        if(month==2){
            if(flag && day>29){
                System.out.println("当前为"+(flag?"闰年":"平年")+"二月份不能大于29");
                return false;
            }
            if(!flag && day > 28){
                System.out.println("当前为"+(flag?"闰年":"平年")+"二月份不能大于28");
                return false;
            }
            if(flag) count=29;
            else count=28;
        }
        if(month==1 || month==3 || month==5|| month==7|| month==8|| month==10|| month==12)
        {
            if(day<=0 || day > 31){
                System.out.println("检查日期的范围");
                return false;
            }
            count =31;
        }
        else if(month!=2){
            if(day<=0 || day>30){
                System.out.println("检查日期的范围");
                return false;
            }
            count = 30;
        }
        return true;
    }



    private static int getData() {
        int tmpDay=1;// 表示
        int a;
        if (month == 1 || month == 2) { month += 12; year--; }
        if((year<1752) || (year==1752 && month<9) ||
                (year==1752 && month==9 && tmpDay<3)){
            a = (tmpDay + 2*month + 3*(month+1)/5 + year + year/4 +5) % 7;
        }else{
            a = (tmpDay + 2*month + 3*(month+1)/5 + year + year/4 - year/100 + year/400)%7;
        }
        return a;
    }

    private static boolean getInput() {
        try {
            System.out.print("请输入日期(格式XXXX-XX-XX)：");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            year = Integer.parseInt(str.substring(0, str.indexOf('-')));
            str = str.substring(str.indexOf('-') + 1, str.length());
            month = Integer.parseInt(str.substring(0, str.indexOf('-')));
            str = str.substring(str.indexOf('-') + 1, str.length());
            day = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("格式错误");
        } catch (StringIndexOutOfBoundsException e2) {
            System.out.println("格式错误");
        }
        return false;
    }
}

