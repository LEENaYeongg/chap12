package chap12;
/* Thread 우선순위 : 스케줄러에게 빠른 선택을 받을 수 있도록 우선순위 설정가능.
 * 우선순위가 높다고 무조건 먼저 선택되는 것은 아님. 다만 확률이 높음.
 * 1 : 가장 낮은 우선순위
 * ~ 5 : 기본 우선순위
 * 10 : 가장 높은 우선순위*/

class ThreadPriority extends Thread {
	ThreadPriority(String name) {
		this(name, Thread.NORM_PRIORITY); //이름만 있으면 normal로 설정 가능.
	}

	ThreadPriority(String name, int p) {
		super(name); //스레드 이름 설정
		this.setPriority(p); //우선순위 설정
	}

	@Override
	public void run() {
		try {
			sleep(20);
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < 5; i++)
			System.out.println(this); 
		//Thread[First,1,main] : Thread 클래스의 toString() 호출
		// First : 스레드 이름
		// 1: 우선순위
		// main : 스레드 그룹
		
	}
}

public class ThreadEx3 {
	public static void main(String[] args) {
		System.out.println("높은 우선순위:" + Thread.MAX_PRIORITY);
		System.out.println("기본 우선순위:" + Thread.NORM_PRIORITY);
		System.out.println("낮은 우선순위:" + Thread.MIN_PRIORITY);
		Thread t1 = new ThreadPriority("First", 1); //낮은 우선순위 스레드
		Thread t2 = new ThreadPriority("Second"); //중간 우선순위 스레드
		Thread t3 = new ThreadPriority("Third",10); //높은 우선순위 스레드
		t1.start();t2.start();t3.start(); //스레드의 우선순위가 낮은 순위부터 스타트.
		System.out.println("main 종료");
	}
}
