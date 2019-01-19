package zztest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(11);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			List<Future> lis= new ArrayList<>();
			lis.add(executor.submit(new Processor(latch, i)));
		}
		try {
			latch.await();
			System.out.println("main thread will not execute untill latch counts come to 0"
					+ " that means if total thread is less than count of latches then it'll wait foreever");
			executor.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all completed");
		
	}

}
class Processor implements Runnable{
	CountDownLatch latch = null;
	int id =0;
	public Processor(CountDownLatch latch, int id) {
		super();
		this.latch = latch;
		this.id = id;
	}

	public void run(){
		System.out.println("Thread "+id+" started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
}