import java.util.*;
public class Triangle{
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		int s[]=new int[3];
		while(true){

			for(int i=0;i<3;i++){
				s[i]=reader.nextInt();
			}
			Arrays.sort(s);
			System.out.println(Arrays.toString(s));
			if(s[0]+s[1]>s[2]){
				System.out.println(s[0]+" "+s[1]+" "+s[2]+"可以构成三角形");
				break;
			}
			else
				System.out.println(s[0]+" "+s[1]+" "+s[2]+"不可以构成三角形");
		}
	}
}