public class Color{
static public enum TestEnum{
E_a("��"),
E_b("��"),
E_c("��"),
E_d("��"),
E_e("��"),
E_f("��"),
E_g("��");
public final String text;
TestEnum(String t){
text=t;
}
}
public static void main(String[] args){
for(TestEnum e : TestEnum.values())
System.out.println(e.text);
}
}