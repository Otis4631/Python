import java.text.*;
public class Translate{
	public static void main(String args[]){
		DecimalFormat df = new DecimalFormat("000.00%");
		double number;
		try{
			Number num = df.parse("100.30%");//将字符串转化为整数
			number = num.doubleValue();//将百分数转化为double
			df.applyPattern("0.00\u2030");
			String result = df.format(number);
			System.out.println("转化为千分数："+result);
			df.applyPattern("0.0000￥");
			result = df.format(number);
			System.out.println("转化为人民币："+result);
		}
		catch(Exception exp){}
		
		
	}
}