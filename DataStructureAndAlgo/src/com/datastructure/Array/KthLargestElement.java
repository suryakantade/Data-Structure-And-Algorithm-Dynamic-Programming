package com.datastructure.Array;

import java.util.Stack;

public class KthLargestElement {
  public static void main(String[] args) {

  }

  public static int findKthMax(int[] arr, int k) {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
      if (min > arr[i]) {
        min = arr[i];
      }
      if (stack.isEmpty()) {
        stack.push(arr[i]);
      } else {
        if (stack.size() >= k) {
          if(min <arr[i]){
            pushWithSort(stack, arr[i]);
            min = removeLast(stack);
          }else {
            pushWithSort(stack, arr[i]);
          }
        }
      }
    }
    int tmp = 0;
    for (int i =0;i<stack.size();i++){
      tmp = stack.pop();
      if(i==k-1){
        break;
      }
    }
    return tmp;
  }

  public static Stack<Integer> pushWithSort(Stack<Integer> stack, int e) {
    if (stack.isEmpty()) {
      stack.push(e);
    } else {
      if (stack.peek() < e) {
        stack.push(e);
      } else {
        int tmp = stack.pop();
        pushWithSort(stack, e);
        stack.push(tmp);
      }
    }
    return stack;
  }

  public static int removeLast(Stack<Integer> stack){
    int tmp = stack.pop();
    int res = 0;
    if(stack.size()==1){
      res = stack.pop();
    }else{
      res = removeLast(stack);
    }
    stack.push(tmp);
    return res;
  }
}
