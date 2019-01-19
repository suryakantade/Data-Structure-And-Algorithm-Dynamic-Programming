package zztest;
class Process implements Runnable{
	public Object lock;
	
	public Process(Object lock) {
		super();
		this.lock = lock;
	}
	public volatile static int j=0;
	public void run(){
		for(int i=0;i<1000;i++){
			synchronized (lock) {
				j++;
			}
		}
		
	}
}
public class Synchronized {

	public static void main(String[] args) {
		Object o = new Object();
		Thread t = new Thread(new Process(o));
		Thread t2 = new Thread(new Process(o));
		t.start();
		t2.start();
		
		try {
			t2.join();
			t.join();
			System.out.println(Process.j);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
