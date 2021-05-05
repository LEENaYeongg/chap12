package chap12;
/* InterruptedException ���� �߻�
 * �����忡�� ���Ǵ� �ֿ� �޼���
 * 1. start() : ����ȭ ���, run() �޼��� ȣ��.
 * 				new���� => Runnable(���డ��)���� -> �������� ���డ��.
 * 2. run() : �����尡 �����ϴ� �޼���. �������̵� �ؾ���.
 * 3. setPriority(1~10) : �켱���� ����
 * 4. sleep(�и���) : �и��� ���� ��� ����
 * 5. Join() : �����尡 �����Ҷ����� ���
 * 6. setDaemon(boolean) : ���󽺷���� ����
 * 						   new ���¿����� �����. => �ƴϸ� ����
 * 7. interrupt() : InterruptedException �߻�.
 * 8. yield() : ����(running)���� �����带 ���డ���� ���·� ����
 * 9. stop() : ������ ���� ����. ������� �ʵ��� �ǰ�. 
 * 
 * ����ȭ ���� : synchronized => wait()�� notify()
 *   ����ȭ �� : lock ����. ������ü�� lock ����
 *   ����ȭ�޼��� : ������ü�� �޼��忩����.
 * 
 * */
class InterruptThread extends Thread{
	public void run() {
		System.out.println("�ڰ� �ֽ��ϴ�. ������������");
		try {
			sleep(1000000); //���ͷ�Ʈ�ϰ� ���ʵ��� �ܴ�.. �ڰ��վ��~ 
		}catch(InterruptedException e) {
			System.out.println("����������?");
			e.printStackTrace();
		}
	}
}
public class ThreadEx9 {
	public static void main(String[] args) throws InterruptedException{
		InterruptThread t1 = new InterruptThread();
		t1.start();
		Thread.sleep(2000); //main�� �ڴٰ� �Ͼ�ڸ��� t1�� ���ͷ�Ʈ�� �Ǵ�.
		t1.interrupt(); //�ڰ��ִ� Ȥ�� join�� �߻��� �ش� t1�������� InterruptedException �߻� ==> �ٷ� ���� ó��
						//=> ����ó�� ��� 2���� 1. throws, try~catch
						//interrupt()�� �̿��Ͽ� �ڰ��ִ� �� �����.
 	}

}
