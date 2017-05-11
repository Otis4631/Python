import java.util.*;
public class shuzu{
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int s[]=new int[n];
		for(int i=0;i<n;i++){
			int a=reader.nextInt();
			s[i]=a;
		}
		for(int i=0;i<n-1;i++){
			System.out.print(s[i]+" ");
		}
		System.out.println(s[n-1]);
		
	}
}