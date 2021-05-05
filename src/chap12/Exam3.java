package chap12;

class PrintRunnable3 implements Runnable{
   Printer ptr;
   char ch;
   PrintRunnable3(Printer ptr,char ch) {
      this.ptr = ptr;
      this.ch = ch;
   }@Override
public void run() {
      for(int i=0;i<20;i++) {
         ptr.printChar(ch);
      }
   }
}
//class Printer2{
//   public synchronized void printChar(char ch) {
//      for(int i=0;i<80;i++)System.out.print(ch);
//      System.out.println();
//   }
//}
public class Exam3 {
   public static void main(String[] args) {
      Printer ptr = new Printer();//Printer:객체 1개
//      Thread t1 = new Thread(new PrintRunnable3(ptr,'A'));
//      Thread t2 = new Thread(new PrintRunnable3(ptr,'B'));
//      Thread t3 = new Thread(new PrintRunnable3(ptr,'C'));
      Thread t1 = new Thread(new PrintRunnable3(ptr,'A'));
      Thread t2 = new Thread(new PrintRunnable3(ptr,'B'));
      Thread t3 = new Thread(new PrintRunnable3(ptr,'C'));
      t1.start();t2.start();t3.start();//하나의 객체를 가지고 처리
      

   }

}
