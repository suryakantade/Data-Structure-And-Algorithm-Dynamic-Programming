package com.surya.Stack;

import java.util.Stack;

public class ReverseStack {

	public ReverseStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("before reverse "+stack.toString());
		reverse(stack);
		
	}
	public static void reverse(Stack<Integer> stack){
		Integer i = stack.pop();
		if(stack.size()>=1){
			reverse(stack);
		}
		pushToBottom(stack, i);
		System.out.println("after reverse " +stack.toString());
	}
	public static void pushToBottom(Stack<Integer> stack , Integer i){
		if(stack.isEmpty()){
			stack.push(i);
		}else{
			Integer tmp = stack.pop();
			pushToBottom(stack, i);
			stack.push(tmp);
		}
	}

}
