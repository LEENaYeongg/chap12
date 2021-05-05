package test_1021;

/*1. 1���� 1000������ ���� 5���� �����尡 ������ ���� ���ϱ� : Thread Ŭ������ ��ӹ޴� ������� �����ϱ�
t1 : 1 ~ 200���� ��
t2 : 201 ~400���� ��
t3 : 401 ~ 600���� ��
t4 : 601 ~ 800���� ��
t5 : 801 ~ 1000���� ��

main ������ : ��� �����尡 �����Ҷ� ���� ��ٷȴٰ� 
��� �������� ���� ���ؼ� 1 ~ 1000������ �� ����ϴ� ���α׷� �����ϱ�
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
			System.out.println(num+1 +"~"+(num+200)+"������ ��:" + sum);
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
		System.out.println("��� ��������� �� : " + (t1.sum+t2.sum+t3.sum+t4.sum+t5.sum));
	}
}
