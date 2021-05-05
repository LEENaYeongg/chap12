package chap12;
/* 동기화 블럭 예제 : synchronized 예약어 사용함
 * 동기화 블럭
 * 동기화메서드 예제 */
class PrintThread3 extends Thread {
	Printer ptr;
	char ch;
	PrintThread3(Printer ptr, char ch){
		this.ptr = ptr;
		this.ch = ch;
		}
	public void run() {
		for(int i =0; i<20; i++) {
			ptr.printChar(ch);
		}
	}
}
class Printer {
	public synchronized void printChar(char ch) {
		for(int i=0; i<80; i++) System.out.print(ch);
		System.out.println();
	}
}
public class ThreadEx6 {
	public static void main(String[] args) {
		Printer ptr = new Printer();
		PrintThread2 t1 = new PrintThread2('A');
		PrintThread2 t2 = new PrintThread2('B');
		PrintThread2 t3 = new PrintThread2('C');
		t1.start();t2.start();t3.start();
	}

}
