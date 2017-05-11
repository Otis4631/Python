
public class StackText {
	public static void main(String arg[]){
		Stack s=new Stack();
		int a=1;
		int b=2;
		System.out.println("将"+a+"放入栈中");
		s.push(a);
		System.out.println("将"+b+"放入栈中");
		s.push(b);
		System.out.println("栈顶的值为"+s.get());
		System.out.println("出栈");
		s.pop();
		System.out.println("栈顶的值为"+s.get());
	}
}
