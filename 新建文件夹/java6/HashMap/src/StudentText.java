import java.util.*;
public class StudentText {
	public static void main(String arg[]){
		Student s1=new Student("name1");
		Student s2=new Student("name2");
		Student s3=new Student("name3");
		Student s4=new Student("name4");
		HashMap map=new HashMap();
		map.put("jisuanji",s1);
		map.put("waiguoyu", s2);
		map.put("jisuanji", s3);
		map.put("waiguoyu", s4);
		Student s=(Student)map.get("jisuanji");
		System.out.println(s.show());
		System.out.println(map.get("waiguoyu"));
	}
}
