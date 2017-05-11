package com.company;

import java.util.*;
public class Main{
    public static void main (String atrg[]){
        Scanner s = new Scanner(System.in);
        String str[] = new String[10];
        for(int i = 0;i < 10;i ++){
            str[i] = s.next();
        }
        Arrays.sort(str);
        int i=0;
        String ss = new String();
        for(String d:str){
            StringBuffer sb = new StringBuffer(d);
            sb.insert(0,String.valueOf(i));
            if(i!=9)
                sb.insert(sb.length(), '&');
            i++;
            ss = ss + sb.toString();

        }
        String[] stringArrays = ss.split("&");
        for(String q:stringArrays){
            System.out.println(q.toUpperCase());
        }
    }
}
