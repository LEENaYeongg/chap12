package test_1021;

/*1. 1부터 1000까지의 합을 5개의 스레드가 나누어 합을 구하기 : Thread 클래스를 상속받는 방식으로 구현하기
t1 : 1 ~ 200까지 합
t2 : 201 ~400까지 합
t3 : 401 ~ 600까지 합
t4 : 601 ~ 800까지 합
t5 : 801 ~ 1000까지 합

main 스레드 : 모든 스레드가 종료할때 까지 기다렸다가 
모든 스레드의 합을 더해서 1 ~ 1000까지의 합 출력하는 프로그램 구현하기
 */
class TestThread extends Thread {
	long sum;
	int num;

	TestThread(int num) {
		this.num = num;
	}

	static Object lock = new Object();

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = num; i <= (num + 200); i++) {
				sum += i;
			}
			System.out.println(num+1 +"~"+(num+200)+"까지의 합:" + sum);
		}
	}
}

public class Test1 {
	public static void main(String[] args) {
		TestThread t1 = new TestThread(0);
		TestThread t2 = new TestThread(200);
		TestThread t3 = new TestThread(400);
		TestThread t4 = new TestThread(600);
		TestThread t5 = new TestThread(800);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
		}
		System.out.println("모든 스레드들의 합 : " + (t1.sum+t2.sum+t3.sum+t4.sum+t5.sum));
	}
}
