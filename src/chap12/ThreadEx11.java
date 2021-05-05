package chap12;

/* wait(), notify(), notifyAll() 메서드 예제
 * * 1.동기화 영역(동기화블럭,동기화메서드)에서만 호출가능
 * 2.Object 클래스의 멤버 메서드임.=>모든객체는 호출이 가능함
 * 3.wait() : 실행중인 스레드를 대기상태로 변환. lock해제함
 *  notify() : wait() 스레드 한개를 Runnable 상태로 변환함
 *             개발자가 스레드 지정 불가
 *  notifyAll() : wait() 스레드 모두를 Runnable 상태로 변환함
 * */
class ATM2 implements Runnable {
	private int money = 100000;

	public void run() {
		try {
			Thread.sleep((int) (Math.random() * 1000));
		} catch (InterruptedException e) {
		}
		synchronized (this) { // this = ATM
			while (true) {
				if (money <= 0) {
					notifyAll();
					break;
				}
				withdraw();
				if (money % 20000 == 0) {
					try {
						wait(); // lock을 가지고 있던 객체가 wait
					} catch (InterruptedException e) {
					}
				} else {
					notifyAll(); // 현재 대기중인 엄마를 깨워~
				}
			}
		}

	}

	private void withdraw() {
		if (money <= 0)
			return;
		money -= 10000;
		System.out.println(Thread.currentThread().getName() + "출금, 잔액:" + money);

	}
}

public class ThreadEx11 {
	public static void main(String[] args) {
		ATM2 atm = new ATM2();
		Thread mother = new Thread(atm, "MOTER");
		Thread son = new Thread(atm, "SON");
		mother.start();
		son.start();

	}
}
