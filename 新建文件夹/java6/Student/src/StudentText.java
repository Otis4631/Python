import java.util.*;
public class StudentText {
	public static void main(String args[]){
		Student s1=new Student("name1");
		Student s2=new Student("name2");
		Student s3=new Student("name3");
		ArrayList List = new ArrayList(3);
		List.add(s1);
		List.add(s2);
		List.add(s3);
		//for(Student student : List){
		//	System.out.println(Student.show());
		//}
		for(int i=0;i<List.size();i++) {
			//System.out.println((Student)List.get(i).show());
			Student s = (Student) List.get(i);
			System.out.println(s.show());
		}
	}

}
