package com.company;

import java.util.*;
public class Main {
    public static void main (String atrg[]){
        Scanner s = new Scanner(System.in);
        String ss = s.next();
        ss = ss.replaceFirst("-", "年");
        ss = ss.replaceFirst("-", "月");
        StringBuffer sb = new StringBuffer(ss);
        sb.insert(ss.length(), '日');
        System.out.println(sb);
    }
}

