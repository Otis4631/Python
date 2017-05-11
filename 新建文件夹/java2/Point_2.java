class Point{
	int x;
	int y;
	public Point(){
	}
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public void setXY(int x,int y){
		this.x=x;
		this.y=y;
	}
	public String toString(){
		return "点("+x+","+y+")到原点的距离为"+distance();
	}
	public double distance(){
		return Math.sqrt(x*x+y*y);
	} 
	public double distance(Point t){
		return Math.sqrt((x-t.getx())*(x-t.getx())+(y-t.gety())*(y-t.gety()));
	}
}
public class Point_2{
	public static void main(String args[]){
		Point t1=new Point(1,1);
		System.out.println(t1);
		Point t2=new Point(1,2);
		System.out.println(t1.distance(t2));
	}
}