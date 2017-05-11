/**
 * Created by 小树林 on 2017/4/18.
 */
import java.util.*;
public class StudentText {
    public static void main(String arg[]) {
        Student s1 = new Student("name1");
        Student s2 = new Student("name2");
        Student s3 = new Student("name3");
        Student s4 = new Student("name4");
        ArrayList computer = new ArrayList();
        ArrayList english = new ArrayList();
        computer.add(s1);
        computer.add(s2);
        computer.add(s3);
        english.add(s4);
        HashMap map = new HashMap();
        map.put("jisuanji", computer);
        map.put("waiguoyu", english);
        System.out.println(map);
    }
}
