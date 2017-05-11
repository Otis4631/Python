import java.util.*;
import java.math.*;
public class BigIntegerTest{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		String s1 = new String();
		s1 = in.next();	
		BigInteger bi1;
		try{
			bi1 = new BigInteger(s1);
		}
		catch(NumberFormatException e){
			System.out.println("非法字符，已初始化为11111111111111111111111111111111111111111111");
			bi1 = new BigInteger("11111111111111111111111111111111111111111111");
		}
		String s2 = new String();
		s2 = in.next();
		BigInteger bi2;
		try{
			bi2 = new BigInteger(s2);
		}
		catch(NumberFormatException e){
			System.out.println("非法字符，已初始化为11111111111111111111111111111111111111111111");
			bi2 = new BigInteger("11111111111111111111111111111111111111111111");
		}
		System.out.println("add:"+bi1.add(bi2));
		
		System.out.println("subtract:"+bi1.subtract(bi2));
		
		System.out.println("multiply:"+bi1.multiply(bi2));
		
		System.out.println("divide:"+bi1.divide(bi2));
		
		System.out.println("remainder:"+bi1.remainder(bi2));
	}
}