package chap12;
/* Thread ��ü �����ϱ�
 * 1. Thread Ŭ������ ���� Ŭ������ ������ ��ü ����
 * 2. Runnable �������̽��� ������ ��ü�� �̿��Ͽ� ������ ��ü ����
 * ==> ������ ��ü�� �ΰ��� ���� ���� : �ڹٴ� ���� ��Ӹ� �����ϱ� ������ �� ���� ����� �ٸ� Ŭ������ ��ӹ��� �� ���� ����.
 * 	   Runnable �������̽��� ������ ��ü : ������ü�� �����尡 �ƴ�.*/

class Thread1 extends Thread {
	Thread1(String name) {
		super(name);
	}

	// run() : �����尡 �����ؾ��� ���.�������̵� �ؾ���.
	@Override
	public void run() { // 3. Running ����. run �޼��� ���� ��.
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "=" + getName());
			try {
				sleep(1000); // 4. ������.=> �����尡 ������ ����.
				// ������ �����Ǹ� Runnable ���·� �����.
			} catch (InterruptedException e) {
			}
		}
	} //5. Dead ����. => �������� ���� ����. ���ÿ��� �޸� ������ ����.
}

public class ThreadEx1 {
	public static void main(String[] args) {
		System.out.println("main ������ ����");
		Thread1 t1 = new Thread1("First"); // 1. new ����
		Thread1 t2 = new Thread1("Second"); // 1. new ����
		t1.start(); // ����.
		t2.start(); // 2. Runnable ����
		/*
		 * start() : �������� ����. 
		 * 1. ���ÿ����� ����ȭ ��. 
		 * 2. ����ȭ�� ���� ������ run() �޼��� ȣ��
		 */
		System.out.println("main ������ ����");
	}
}