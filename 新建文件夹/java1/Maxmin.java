import java.util.*;
public class Maxmin{
	public static void main(String args[]){
	Scanner reader=new Scanner(System.in);
	int [] s=new int[10];
	for(int i=0;i<10;i++)
	{
		s[i]=reader.nextInt();
	}
	int max=s[0],min=s[0];
	for(int i=0;i<10;i++)
	{
		if(s[i]>max)max=s[i];
		if(s[i]<min)min=s[i];
	}
	System.out.println(max);
	System.out.println(min);
}
}