import java.util.*;
class  Point{
	double a;
	double b;
	double c;
	double d;
	Scanner reader=new Scanner(System.in);
	double distance(){
		return Math.sqrt((a-c)*(a-c)+(b-d)*(b-d));
	}
	double get(){
		double x=reader.nextDouble();
		return x;
	}
	void print1(){
		System.out.println("�㣨"+a+","+b+")���㣨"+c+","+d+")�ľ���Ϊ��"+distance());
	}
}
public class Point_16{
	public static void main(String args[]){
		Point p;
		p=new Point();
		System.out.println("������һ���������");
		p.a=p.get();
		p.b=p.get();
		p.print1();
		System.out.println("����������һ���������");
		p.c=p.get();
		p.d=p.get();
		p.print1();
	}
}