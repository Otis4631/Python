import java.util.*;
class  Student{
	double x;
	double y;
	double z;
	Scanner reader=new Scanner(System.in);
	void get(){
		x=reader.nextDouble();
		y=reader.nextDouble();
		z=reader.nextDouble();
	}
	double grade1(){
		return x+y+z;
	}
	double grade2(){
		return (x+y+z)/3.0; 
	}
	void print1(){
		System.out.println("��ѧ�����ܳɼ�Ϊ"+grade1());
	}
	void print2(){
		System.out.println("��ѧ����ƽ���ɼ�Ϊ"+grade2());
	}
}
public class Student_17{
	public static void main(String args[]){
		Student S;
		S=new Student();
		System.out.println("����������Ӣ�ɼ�");
		S.get();
		S.grade1();
		S.grade2();
		S.print1();
		S.print2();
	}
}