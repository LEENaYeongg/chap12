package test_1020;
/* 1. ThreadEx3.java �ҽ��� Runnable �������̽� ���� ������� �����Ͽ� ���� ����� ��µǵ��� �����ϱ� */

class Runnable1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread());

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class Test1 {
	public static void main(String[] args) {
		Runnable1 r = new Runnable1();
		System.out.println("���� �켱����:" + Thread.MAX_PRIORITY);
		System.out.println("�⺻ �켱����:" + Thread.NORM_PRIORITY);
		System.out.println("���� �켱����:" + Thread.MIN_PRIORITY);
		Thread t1 = new Thread(r,"First"); 
		Thread t2 = new Thread(r,"Second"); 
		Thread t3 = new Thread(r,"Third"); 
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start(); 
		System.out.println("main ������ ����");
	}
}
