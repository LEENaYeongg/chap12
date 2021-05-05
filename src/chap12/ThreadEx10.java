package chap12;

class ATM implements Runnable {
	private int money= 100000;
	public void run() {
		try {
			Thread.sleep((int)(Math.random() * 1000)); //0~999까지 랜덤하게 쉼.
		}catch(InterruptedException e) {}
		synchronized (this) { //동기화로 나(atm)를 씀. => ATM: 마더와 썬이 동시에 공유하는 공유객체
			while(true) {
				if(money<=0) break;
				withdraw();
			}
		}
	}
	private void withdraw() {
		if(money<=0)return;
		money -=10000;
		System.out.println(Thread.currentThread().getName()+"출금, 잔액:"+money);
	}
}
public class ThreadEx10 {
	public static void main(String[] args) {
		ATM atm = new ATM(); //atm 객체
		Thread mother = new Thread(atm, "MONSTER"); //마더 스레드 생성
		Thread son = new Thread(atm, "SON"); // 선 스레드 생성
		mother.start();son.start();
	}

}
