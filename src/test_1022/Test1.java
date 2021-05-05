package test_1022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 1. Ÿ�� ���� ���� ���α׷� �����ϱ�
String[] data =  { "�¿�","����","����","ȿ��","����","����","Ƽ�Ĵ�","���","����ī" };
List<String> words = new ArrayList<String>();
3�ʿ� �ѹ��� words�� data �� ������ �̸��� �߰��ϱ�.  => ������(DataAddThread)�� �ۼ�.
ȭ�鿡 �Էµ� �̸���, words�� ����� �̸��� ���� ��� words���� �Էµ� �̸��� �����Ѵ�.
words�� ��� �����Ͱ� ���� �Ǹ� ���α׷��� �����Ѵ�. 
*/

public class Test1 {
	String[] data = {"�輮��","������","�賲��","��ȣ��","������","������","������","��Ƽ����"};
	List<String> words = new ArrayList<String>();
	 int interval = 3*1000;//3��
	    public static void main(String[] args) {
	    	Test1 g = new Test1();
	       g.game();
	       System.out.println("���α׷� ����");
	       
	    }
	    public void game(){
	       Scanner scan = new Scanner(System.in);
	       words.add(data[0]);
	       DataAddThread t1 = new DataAddThread(words,data,interval);
	       t1.setDaemon(true);//���� ������
	       t1.start();
	       while(true) {
	          System.out.println(words);
	          System.out.print(">>");
	          String input = scan.next().trim();
	          words.remove(input);
	          if(words.size() ==0) break;
	       }
	    }
	}
	class DataAddThread extends Thread{
	   List<String> words;
	   String[] data;
	   int interval;
	   public DataAddThread
	   (List<String> words,String[] data,int interval) {
	      this.words = words;
	      this.data = data;
	      this.interval = interval;
	   }
	   @Override
	   public void run() {
	      while(true) {
	         try {
	            sleep(interval);
	         }catch(InterruptedException e) {}
	      words.add(data[(int)(Math.random()*data.length)]);   
	      }
	   }
	}