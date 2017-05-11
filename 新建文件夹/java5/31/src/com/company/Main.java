package com.company;

import java.util.*;
public class Main{
    public static void main (String atrg[]){
        Scanner s = new Scanner(System.in);
        StringBuffer sz = new StringBuffer(s.next());
        String ss = sz.toString();
        int pos = 97 + ss.length()-1;
        for(int i=0,j=0;i<ss.length();i++,j++){
            //if(i+1 != ss.length())
            sz.insert(i+j, String.valueOf((char)pos));

            pos--;
        }

        ss = sz.toString();
        char arr[] = ss.toCharArray();
        for(int i = ss.length() - 1;i >= 0;i --){
            System.out.print(arr[i]);
        }
    }
}

