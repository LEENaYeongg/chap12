package chap12;
/* 동기화 블럭 예제 : synchronized 예약어 사용함 */
class PrintThread2 extends Thread {
	char ch;
	PrintThread2(char ch){
		this.ch = ch;
		}
	// lock 객체는 모든 스레드가 공유하는 객체여아함.
	// lock 객체는 객체여야함. => 기본형은 사용 불가.
//	static Object lock = new Object();
//	static Object lock = new Object("a");
//	static int lock =0; // error
	static Integer lock =0;
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (lock) { //동기화 영역(동기화블럭)
				for (int j = 0; j < 80; j++) { //80개를 다 찍을 동안 흐트러지지않음. 다른것들이 침범 X
					System.out.print(ch);
				}
				System.out.println();
			}
		}
	}
}

public class ThreadEx5 {
	public static void main(String[] args) {
		PrintThread2 t1 = new PrintThread2('A');
		PrintThread2 t2 = new PrintThread2('B');
		PrintThread2 t3 = new PrintThread2('C');
		t1.start();t2.start();t3.start();
	}
}
