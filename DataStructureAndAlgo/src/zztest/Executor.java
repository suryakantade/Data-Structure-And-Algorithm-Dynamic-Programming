package zztest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorProcess implements Runnable {
	public int id;
	public ExecutorProcess(int id) {
		super();
		this.id = id;
	}

	public void run() {
		System.out.println(id+ "running");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(10);
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			executor.submit(new ExecutorProcess(i));
			latch.countDown();
			
		}
		try {
			latch.await();
			//System.out.println("**************FInished********************");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
