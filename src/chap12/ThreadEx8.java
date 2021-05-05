package chap12;
/* 데몬 스레드
 * 1. 일반스레드의 보조역할을 담당함. 무한반복처리함.
 *    가비지 콜렉터(쓰레기콜렉터) : 데몬스레드
 * 2. 일반스레드가 종료되면 데몬스레드도 종료됨.
 * 3. setDaemon(true)
 *    => new 상태에서만 설정이 가능.
 *    */
class DaemonThread extends Thread{
	public void run() {
		while(true) {
			System.out.println(this);
			try {sleep(100);
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx8 {

	public static void main(String[] args) throws InterruptedException { //main이 일반스레드
		Thread t1 = new DaemonThread();
		Thread t2 = new DaemonThread();
		t1.setDaemon(true);t2.setDaemon(true); //데몬스레드 설정
		t1.start();t2.start();
		Thread.sleep(2000); //대기해~
		System.out.println("main 스레드 종료");
		//계속 돌면서 쓰레기 수집을 하면돼~
	}
}
