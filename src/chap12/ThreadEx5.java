package chap12;
/* ����ȭ �� ���� : synchronized ����� ����� */
class PrintThread2 extends Thread {
	char ch;
	PrintThread2(char ch){
		this.ch = ch;
		}
	// lock ��ü�� ��� �����尡 �����ϴ� ��ü������.
	// lock ��ü�� ��ü������. => �⺻���� ��� �Ұ�.
//	static Object lock = new Object();
//	static Object lock = new Object("a");
//	static int lock =0; // error
	static Integer lock =0;
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (lock) { //����ȭ ����(����ȭ��)
				for (int j = 0; j < 80; j++) { //80���� �� ���� ���� ��Ʈ����������. �ٸ��͵��� ħ�� X
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
