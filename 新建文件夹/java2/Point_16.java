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
		System.out.println("点（"+a+","+b+")到点（"+c+","+d+")的距离为："+distance());
	}
}
public class Point_16{
	public static void main(String args[]){
		Point p;
		p=new Point();
		System.out.println("请输入一个点的坐标");
		p.a=p.get();
		p.b=p.get();
		p.print1();
		System.out.println("请输入任意一个点的坐标");
		p.c=p.get();
		p.d=p.get();
		p.print1();
	}
}