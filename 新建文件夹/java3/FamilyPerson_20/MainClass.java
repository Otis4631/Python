public class MainClass {  
   public static void main(String args[]) {
        //������1�� //������FamilyPerson����surname,��Ϊsurname��ֵ:"��"
	FamilyPerson.surname="��";
	FamilyPerson father,sonOne,sonTwo;
	father = new  FamilyPerson();
	sonOne = new  FamilyPerson();
	sonTwo = new  FamilyPerson();
        //������2�� //father����setName(String s),����s����"����"
	father.setName("����");
	sonOne.setName("����");
	sonTwo.setName("��ս"); 
	System.out.println("����:"+father.surname+father.name);
	System.out.println("�����:"+sonOne.surname+sonOne.name);
	System.out.println("������:"+sonTwo.surname+sonTwo.name);  
	//������3��// father����setSurName(String s),����s����"��"
	father.setSurname("��");
	System.out.println("����:"+father.surname+father.name);
	System.out.println("�����:"+sonOne.surname+sonOne.name);
	System.out.println("������:"+sonTwo.surname+sonTwo.name);  
    }
}


