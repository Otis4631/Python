package cn.sdut.jsj;
import java.util.*;
import cn.sdut.ruanjian.*;
public class Complix_18{
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		int a=reader.nextInt();
		int b=reader.nextInt();
		int c=reader.nextInt();
		int d=reader.nextInt();
		Complix t1=new Complix(a,b);
		Complix t2=new Complix(c,d);
		System.out.println(t1.toString(t2));
	}
}