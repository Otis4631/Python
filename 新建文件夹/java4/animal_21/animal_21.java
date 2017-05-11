class Animal{
	void cry(){
	}
}
class Dog extends Animal{
	void cry(){
		System.out.println("wang wang");
	}
}
class Cat extends Animal{
	void cry(){
		System.out.println("miao miao");
	}
}
class Simulator{
	void play(Animal d){
	d.cry();
	}
}
public class animal_21{
	public static void main(String arg[]){
		Dog d=new Dog();
		Cat c=new Cat();
		Simulator s=new Simulator();
		s.play(d);
		s.play(c);
	}
}