package com.datastructure.LinkedListDouble;

import java.util.Arrays;

public class Queue {

	int front, rear, size;
	int capacity;
	int arr[];

	public Queue(int capacity) {
		super();
		this.front = this.size = 0;
		this.rear = capacity - 1;
		this.capacity = capacity;
		this.arr = new int[capacity];
	}

	public void enque(int val) {
		if(isFull()){
			return;
		}
		this.rear=(this.rear+1)%this.capacity;
		arr[this.rear]= val;
		this.size++;
		System.out.println(val+" is enqueued");
	}
	public int deque(){
		if(isEmpty()){
			return Integer.MIN_VALUE;
		}
		int response = arr[this.front];
		this.front = (this.front+1)%this.capacity;
		this.size--;
		System.out.println(response+" is dequeued");
		return response;
	}
	public boolean isEmpty(){
		if(this.size == 0)
			return true;
		return false;
	}
	public boolean isFull(){
		if(this.size == capacity)
			return true;
			return false;
	}
	public void traverseQueue(){
		System.out.println(Arrays.toString(this.arr));
	}
	public int frontElement(){
		return arr[this.front];
	}
	public int rearElement(){
		return arr[this.rear];
	}
	public void enqueAll(){
		for(int i=0;i<10;i++){
			this.enque(i);
		}
	}
	public void dequeueAll(){
		for(int i = 0;i<10;i++){
			deque();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(100);
		queue.enqueAll();
		System.out.println("\n");
		queue.dequeueAll();
	}

}
