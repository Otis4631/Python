import java.util.*;
public class Ex3{
	public static void main(String args[]){
		System.out.println("���������ɸ�����ÿ����һ�����س�ȷ��");
		System.out.println("�����������0�����������");
		Scanner reader=new Scanner(System.in);
		double sum=0;
		int m=0;
		double a=reader.nextDouble();
		while(a!=0){
			m=m+1;
			sum=sum+a;
			a=reader.nextDouble();
		}
		System.out.println(m+"�����ĺ�Ϊ"+sum);
		System.out.println(m+"������ƽ��ֵ"+sum/m);
	}
}