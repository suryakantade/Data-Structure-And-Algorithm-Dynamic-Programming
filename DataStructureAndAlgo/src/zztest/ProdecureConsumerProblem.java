package zztest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ProdecureConsumerProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<>();
		Thread t1 = new Thread(new ProducerConsumer(1, queue));
		Thread t2 = new Thread(new ProducerConsumer(2, queue));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class ProducerConsumer implements Runnable {
	int id = 0;
	Queue<Integer> queue;

	public ProducerConsumer(int id, Queue<Integer> queue) {
		super();
		this.id = id;
		this.queue = queue;
	}

	public void run() {
		if (id == 1) {
			produce();
		} else {
			consume();
		}
	}

	public void produce() {
		while (true) {
			synchronized (queue) {
				if (queue.size() == 10) {
					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					queue.add(1);
					System.out.println("1 pushed , now size is :" + queue.size());
					try {
						Thread.sleep(1000);
						queue.notifyAll();
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}

	public void consume() {
		while (true) {
			synchronized (queue) {
				if (queue.isEmpty()) {
					queue.notifyAll();
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					int i = queue.poll();
					System.out.println(i + " pulled, now size is : " + queue.size());
					try {
						Thread.sleep(1000);
						queue.notifyAll();
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}
}
