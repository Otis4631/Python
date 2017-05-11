class  Rectangular_block{
	double x;
	double y;
	double z;
	Rectangular_block(double a,double b,double c)
	{
		x=a;
		y=b;
		z=c;
	}
	double size(){
		return (x*y)*2+(x*z)*2+(y*z)*2;
	}
	double volume(){
		return x*y*z;
	}
	void print1(double a){
		System.out.println("长方体的表面积："+a);
	}
	void print2(double a){
		System.out.println("长方体的体积："+a);
	}
}
public class Rectangular{
	public static void main(String args[]){
		Rectangular_block Rec;
		Rec=new Rectangular_block(1,2,3);
		double a=Rec.size();
		double b=Rec.volume();
		Rec.print1(a);
		Rec.print2(b);
	}
}