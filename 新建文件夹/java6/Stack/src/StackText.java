
public class StackText {
	public static void main(String arg[]){
		Stack s=new Stack();
		int a=1;
		int b=2;
		System.out.println("��"+a+"����ջ��");
		s.push(a);
		System.out.println("��"+b+"����ջ��");
		s.push(b);
		System.out.println("ջ����ֵΪ"+s.get());
		System.out.println("��ջ");
		s.pop();
		System.out.println("ջ����ֵΪ"+s.get());
	}
}
