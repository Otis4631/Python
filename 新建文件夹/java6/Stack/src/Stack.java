import java.util.*;
public class Stack {
	public LinkedList list= new LinkedList();
	public void push(Object obj){
		list.addLast(obj);
	}
	public Object get(){
		return list.getLast();
	}
	public Object pop(){
		return list.removeLast();
}
}
