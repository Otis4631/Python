import java.util.*;
public class Ex7{
	public static void main(String args[]){
		int [] a={12,34,9,23,45,6,45,90,123,19,34};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int number=45;
		int index=Arrays.binarySearch(a,number);
		if(index>=0){
		System.out.println(number+"������������Ϊ"+index+"��Ԫ��ֵ��ͬ");
		}
		else{
		System.out.println(number+"���������е�Ԫ��ֵ��ͬ");
		}
		
		
	}
}