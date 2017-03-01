package concurrency;

import java.util.concurrent.TimeUnit;

class MyThread implements Runnable {
	private Integer id;
	public MyThread(int id){
		this.id = id;
	}
	public void run() {
		if(id != 2){
			Thread mts1 = new Thread(new MyThreadSon());
			mts1.setDaemon(true);
			mts1.start();
			System.out.println("MyThread nmts1 started");
			
			Thread mts2 = new Thread(new MyThreadSon());
			mts2.setDaemon(true);
			mts2.start();
			System.out.println("MyThread mts2 started");
		}
	}
}

class MyThreadSon implements Runnable {
	public void run() {
		System.out.println("start MyThreadSon" + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end MyThreadSon" + Thread.currentThread().getName());
	}
}

public class DaemonTest {
	public static void main(String[] args) {
		Thread mt1 = new Thread(new MyThread(1));
		mt1.start();
		
		System.out.println("end mt1 main");
		Thread mt2 = new Thread(new MyThread(2));
		mt2.start();
		try {	
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end mt2 main");
	}
}
