package com.datastructure.Stack;

import java.util.Stack;

public class DeleteMiddleElementStack {

	public DeleteMiddleElementStack() {
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
		stack.push(6);
		stack.push(7);
		System.out.println("before reverse " + stack.toString());
		int pos = deleteMiddleElement(stack, 1);
		System.out.println("after deletion "+stack.toString());
	}

	public static int deleteMiddleElement(Stack<Integer> stack, int currentpos) {
		if (stack.isEmpty()) {
			return currentpos-1;
		} else {
			int i = stack.pop();
			int pos =deleteMiddleElement(stack, 1 + currentpos);
			if (currentpos != pos / 2) {
				stack.push(i);
			}else{
				System.out.println(pos +"     "+currentpos);
			}
			return pos;
		}

	}
}
