package com.company;

import java.util.*;
public class Main {
    public static void main (String atrg[]){
        Scanner s = new Scanner(System.in);
        String str[] = new String[10];
        for(int i = 0;i < 10;i ++){
            str[i] = s.next();
        }
        Arrays.sort(str);
        for(String d:str){
            System.out.println(d);
        }

    }
}



