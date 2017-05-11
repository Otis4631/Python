public class BankOfDalian extends Bank {
   double year;
   public double computerInterest() {
      super.year=(int)year;
      double r = year-(int)year;
      int day=(int)(r*1000);
      double yearInterest = super.computerInterest();
      double dayInterest = day*0.00012*savedMoney;
      interest= yearInterest+dayInterest;
      System.out.printf("%dԪ���ڴ�������%d����%d�����Ϣ:%fԪ\n",
                         savedMoney,super.year,day,interest);
      return interest;
   }
}