package com.surya.LinkedListDouble;

public class PriorityQueue {
	
	QueueNode<Integer> head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue pq = new PriorityQueue();
		pq.enqueueAll();
		pq.traverse();
		
	}
	public void enqueueAll(){
		for(int i=0;i<10;i++){
			enqueue(i, i);
		}
	}
	public void traverse(){
		QueueNode<Integer> temp =  this.head;
		while(temp != null){
			System.out.print(" "+temp.val+"("+temp.priority+") ->");
			temp = temp.next;
		}
	}
	public void enqueue(Integer val,int priority){
		if(this.head == null){
			head = new QueueNode(val, priority, null);
			return;
		}
		QueueNode<Integer> temp = null;
		if(this.head.priority>priority){
			temp = new QueueNode(val, priority, this.head);
			head = temp;
			return;
		}
		temp = this.head;
		a:
		while(temp != null && null != temp.next&& temp.next.priority<priority){
			if(temp.next == null){
				break a;
			}else
				temp = temp.next;
		}
		temp.next = new QueueNode(val, priority, temp.next);
	}
}
class QueueNode<E>{
	Object val;
	int priority;
	QueueNode<E> next;
	public QueueNode(Object val, int priority, QueueNode<E> next) {
		super();
		this.val = val;
		this.priority = priority;
		this.next = next;
	}
}