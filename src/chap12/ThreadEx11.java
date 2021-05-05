package chap12;

/* wait(), notify(), notifyAll() �޼��� ����
 * * 1.����ȭ ����(����ȭ����,����ȭ�޼���)������ ȣ�Ⱑ��
 * 2.Object Ŭ������ ��� �޼�����.=>��簴ü�� ȣ���� ������
 * 3.wait() : �������� �����带 �����·� ��ȯ. lock������
 *  notify() : wait() ������ �Ѱ��� Runnable ���·� ��ȯ��
 *             �����ڰ� ������ ���� �Ұ�
 *  notifyAll() : wait() ������ ��θ� Runnable ���·� ��ȯ��
 * */
class ATM2 implements Runnable {
	private int money = 100000;

	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 1000));
		} catch (InterruptedException e) {
		}
		synchronized (this) { // this = ATM
			while (true) {
				if (money <= 0) {
					notifyAll();
					break;
				}
				withdraw();
				if (money % 20000 == 0) {
					try {
						wait(); // lock�� ������ �ִ� ��ü�� wait
					} catch (InterruptedException e) {
					}
				} else {
					notifyAll(); // ���� ������� ������ ����~
				}
			}
		}

	}

	private void withdraw() {
		if (money <= 0)
			return;
		money -= 10000;
		System.out.println(Thread.currentThread().getName() + "���, �ܾ�:" + money);

	}
}

public class ThreadEx11 {
	public static void main(String[] args) {
		ATM2 atm = new ATM2();
		Thread mother = new Thread(atm, "MOTER");
		Thread son = new Thread(atm, "SON");
		mother.start();
		son.start();

	}
}