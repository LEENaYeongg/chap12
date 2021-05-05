package chap12;
/* InterruptedException 예외 발생
 * 스레드에서 사용되는 주요 메서드
 * 1. start() : 병렬화 기능, run() 메서드 호출.
 * 				new상태 => Runnable(실행가능)상태 -> 언제든지 실행가능.
 * 2. run() : 스레드가 실행하는 메서드. 오버라이딩 해야함.
 * 3. setPriority(1~10) : 우선순위 설정
 * 4. sleep(밀리초) : 밀리초 동안 대기 상태
 * 5. Join() : 스레드가 종료할때까지 대기
 * 6. setDaemon(boolean) : 데몬스레드로 설정
 * 						   new 상태에서만 실행됨. => 아니면 에러
 * 7. interrupt() : InterruptedException 발생.
 * 8. yield() : 실행(running)중인 스레드를 실행가능한 상태로 변경
 * 9. stop() : 스레드 강제 종료. 사용하지 않도록 권고. 
 * 
 * 동기화 영역 : synchronized => wait()과 notify()
 *   동기화 블럭 : lock 설정. 공유객체로 lock 설정
 *   동기화메서드 : 공유객체의 메서드여야함.
 * 
 * */
class InterruptThread extends Thread{
	public void run() {
		System.out.println("자고 있습니다. 깨우지마세요");
		try {
			sleep(1000000); //인터럽트하고 만초동안 잔다.. 자고잇어요~ 
		}catch(InterruptedException e) {
			System.out.println("누가깨웠니?");
			e.printStackTrace();
		}
	}
}
public class ThreadEx9 {
	public static void main(String[] args) throws InterruptedException{
		InterruptThread t1 = new InterruptThread();
		t1.start();
		Thread.sleep(2000); //main도 자다가 일어나자마자 t1의 인터럽트를 건다.
		t1.interrupt(); //자고있는 혹은 join이 발생한 해당 t1스레드의 InterruptedException 발생 ==> 바로 예외 처리
						//=> 예외처리 방법 2가지 1. throws, try~catch
						//interrupt()를 이용하여 자고있는 걸 깨운다.
 	}

}
