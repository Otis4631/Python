public class Color{
static public enum TestEnum{
E_a("ºì"),
E_b("³È"),
E_c("»Æ"),
E_d("ÂÌ"),
E_e("À¶"),
E_f("µå"),
E_g("×Ï");
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