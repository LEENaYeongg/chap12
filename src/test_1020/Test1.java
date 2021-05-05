package test_1020;
/* 1. ThreadEx3.java 소스를 Runnable 인터페이스 구현 방식으로 변경하여 같은 결과가 출력되도록 구현하기 */

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
		System.out.println("높은 우선순위:" + Thread.MAX_PRIORITY);
		System.out.println("기본 우선순위:" + Thread.NORM_PRIORITY);
		System.out.println("낮은 우선순위:" + Thread.MIN_PRIORITY);
		Thread t1 = new Thread(r,"First"); 
		Thread t2 = new Thread(r,"Second"); 
		Thread t3 = new Thread(r,"Third"); 
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start(); 
		System.out.println("main 스레드 종료");
	}
}
