package test_1020;

class Thread1 extends Thread{
	Thread1(String name){ 
		super(name);
	}
	
	@Override
	public void run() { //스레드가 실행할 기능.
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "=" + getName());
			try {
				sleep(1000); 
			} catch (InterruptedException e) {
			}
		}
	}
}
public class Ex {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Thread1 t1 = new Thread1("First");
		Thread1 t2 = new Thread1("Second");
		t1.start();
		t2.start();
		System.out.println("종료");
	}
}