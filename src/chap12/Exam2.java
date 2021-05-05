package chap12;

/* ThreadEx5.java Runnable 방식으로 변경하기 */
class PrintRunnable2 implements Runnable {
	char ch;

	PrintRunnable2(char ch) {
		this.ch = ch;
	}

//	static Object lock = new Object();
	static int[] lock = new int[] {1}; // 배열은 객체로 본다.
	//static 빼면 동기화 효과가 없음.==> why? static이 있으면 객체의 클래스 정보의 1개뿐. static 없으면 객체별로 하나씩 만들어짐.

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (lock) {
				for (int j = 0; j < 80; j++)
					System.out.print(ch);
				System.out.println();
			}
		}
	}
}

public class Exam2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintRunnable2('A'));
		Thread t2 = new Thread(new PrintRunnable2('B'));
		Thread t3 = new Thread(new PrintRunnable2('C'));
		t1.start();t2.start();t3.start();
	}

}
