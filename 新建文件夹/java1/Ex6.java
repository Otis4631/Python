import java.util.*;
public class Ex6{
	public static void main(String args[]){
		int [] a={10,20,30,40,50,60},b,c,d;
		b=Arrays.copyOf(a,10);
		System.out.println("数组a的各元素的值：");
		System.out.println(Arrays.toString(a));
		System.out.println("数组b的各元素的值：");
		System.out.println(Arrays.toString(b));
		c=Arrays.copyOfRange(a,3,5);
		System.out.println("数组c的各元素的值：");
		System.out.println(Arrays.toString(c));
		d=Arrays.copyOfRange(a,3,9);
		System.out.println("数组d的各元素的值：");
		System.out.println(Arrays.toString(d));
		
		
	}
}