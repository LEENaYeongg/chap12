package chap12;

class ATM implements Runnable {
	private int money= 100000;
	public void run() {
		try {
			Thread.sleep((int)(Math.random() * 1000)); //0~999���� �����ϰ� ��.
		}catch(InterruptedException e) {}
		synchronized (this) { //����ȭ�� ��(atm)�� ��. => ATM: ������ ���� ���ÿ� �����ϴ� ������ü
			while(true) {
				if(money<=0) break;
				withdraw();
			}
		}
	}
	private void withdraw() {
		if(money<=0)return;
		money -=10000;
		System.out.println(Thread.currentThread().getName()+"���, �ܾ�:"+money);
	}
}
public class ThreadEx10 {
	public static void main(String[] args) {
		ATM atm = new ATM(); //atm ��ü
		Thread mother = new Thread(atm, "MONSTER"); //���� ������ ����
		Thread son = new Thread(atm, "SON"); // �� ������ ����
		mother.start();son.start();
	}

}
