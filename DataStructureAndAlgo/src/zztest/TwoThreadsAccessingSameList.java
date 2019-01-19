package zztest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TwoThreadsAccessingSameList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Thread t1 = new MyThread(list);
		Thread t2 = new MyThread(list);
		t1.start();
		t2.start();
	}

}
class MyThread extends Thread{
	public List<Integer> list ;
	
	public MyThread(List<Integer> list) {
		super();
		this.list = list;
	}

	public void run(){
		for(int i = 0 ;i<1000;i++){
			Iterator<Integer> ite = list.iterator();
			while(ite.hasNext()){
				System.out.println(ite.next());
				ite.remove();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

interface FunctionalInterfaceExample{
	
}