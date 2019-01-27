package com.surya.Stack;

import java.util.Stack;

public class SortingStack {

	public SortingStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(7);
		stack.push(5);
		System.out.println("before reverse "+stack.toString());
		popAll(stack);
		
	}
	public static void popAll(Stack<Integer> stack){
		Integer i = stack.pop();
		if(stack.size()>=1){
			popAll(stack);
		}
		sort(stack, i);
		System.out.println("after reverse " +stack.toString());
	}
	public static void sort(Stack<Integer> stack , Integer i){
		if(stack.isEmpty()){
			stack.push(i);
		}else{
			Integer tmp = stack.pop();
			if(tmp > i){
				sort(stack, i);
				stack.push(tmp);
			}else{
				stack.push(tmp);
				stack.push(i);
			}
			
		}
	}

}
