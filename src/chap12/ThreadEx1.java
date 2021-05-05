package chap12;
/* Thread 객체 생성하기
 * 1. Thread 클래스의 하위 클래스로 스레드 객체 생성
 * 2. Runnable 인터페이스를 구현한 객체를 이용하여 스레드 객체 생성
 * ==> 스레드 객체를 두개나 만든 이유 : 자바는 단일 상속만 가능하기 때문에 한 개만 만들면 다른 클래스를 상속받을 수 없기 때문.
 * 	   Runnable 인터페이스를 구현한 객체 : 구현객체는 스레드가 아님.*/

class Thread1 extends Thread {
	Thread1(String name) {
		super(name);
	}

	// run() : 스레드가 실행해아할 기능.오버라이딩 해야함.
	@Override
	public void run() { // 3. Running 상태. run 메서드 실행 중.
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "=" + getName());
			try {
				sleep(1000); // 4. 대기상태.=> 스레드가 실행을 멈춤.
				// 대기상태 해제되면 Runnable 상태로 변경됨.
			} catch (InterruptedException e) {
			}
		}
	} //5. Dead 상태. => 스레드의 수행 종료. 스택에서 메모리 영억이 제거.
}

public class ThreadEx1 {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Thread1 t1 = new Thread1("First"); // 1. new 상태
		Thread1 t2 = new Thread1("Second"); // 1. new 상태
		t1.start(); // 실행.
		t2.start(); // 2. Runnable 상태
		/*
		 * start() : 스레드의 시작. 
		 * 1. 스택영역을 병렬화 함. 
		 * 2. 병렬화된 스택 영역에 run() 메서드 호출
		 */
		System.out.println("main 스레드 종료");
	}
}
