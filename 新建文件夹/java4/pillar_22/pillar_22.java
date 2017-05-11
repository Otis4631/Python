abstract class Geometry{
	abstract double getArea();
} 
class Circle extends Geometry{
	double r;
	Circle(double r){
		this.r=r;
	}
	double getArea(){
		return 3.14*r*r;
	}
}
class Rectangle extends Geometry{
	double l;
	double h;
	Rectangle(double l,double h){
		this.l=l;
		this.h=h;
	}
	double getArea(){
		return l*h;
	}
}


class Pillar{
	double height;
	Geometry bottom;
	Pillar(){};
	Pillar(double height,Geometry bottom){
		this.height=height;
		this.bottom=bottom;
	}
	double getVolume(){
		return height*bottom.getArea();
	}
	public String toString(){
		return "Ìå»ýÎª"+getVolume();
	}
}
public class pillar_22{
	public static void main(String arg[]){
		Circle c=new Circle(2);
		Pillar p1=new Pillar(2,c);
		System.out.println(p1);
		Rectangle r=new Rectangle(1,2); 
		Pillar p2=new Pillar(3,r);
		System.out.println(p2);
	}
}