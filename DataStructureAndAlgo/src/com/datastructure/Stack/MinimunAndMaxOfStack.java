package com.datastructure.Stack;

import java.util.Stack;

public class MinimunAndMaxOfStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.add(12);
    stack.add(13);
    stack.add(14);
    stack.add(-1);
    findMaxMin(stack);
  }
  public static void findMaxMin(Stack<Integer> stack){
    int max =Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    while (!stack.isEmpty()){
      int tmp = stack.pop();
      if(tmp>max){
        max = tmp;
      }
      if (tmp<min){
        min = tmp;
      }
    }
    System.out.println("min : "+ min+" max: "+max);
  }
}
