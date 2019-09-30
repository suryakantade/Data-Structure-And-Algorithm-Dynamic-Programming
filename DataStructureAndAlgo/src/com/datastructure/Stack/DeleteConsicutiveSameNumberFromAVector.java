package com.datastructure.Stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/delete-consecutive-words-sequence/
public class DeleteConsicutiveSameNumberFromAVector {
  public static void main(String[] args) {
      String[] arr = {"abc", "def","def","abcd"};
    System.out.println(DeleteConsi(arr));
  }
  public static int DeleteConsi(String[] arr){
    Stack<String> stack = new Stack<>();
    for(int i=0;i<arr.length;i++){
      if(stack.isEmpty()){
        stack.push(arr[i]);
      }else{
        String peek = stack.peek();
        if(peek.equals(arr[i])){
          stack.pop();
        }else{
          stack.push(arr[i]);
        }
      }
    }
    return stack.size();
  }
}
