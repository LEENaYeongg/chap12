package chap12;

/* ThreadEx5.java Runnable ������� �����ϱ� */
class PrintRunnable2 implements Runnable {
	char ch;

	PrintRunnable2(char ch) {
		this.ch = ch;
	}

//	static Object lock = new Object();
	static int[] lock = new int[] {1}; // �迭�� ��ü�� ����.
	//static ���� ����ȭ ȿ���� ����.==> why? static�� ������ ��ü�� Ŭ���� ������ 1����. static ������ ��ü���� �ϳ��� �������.

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
