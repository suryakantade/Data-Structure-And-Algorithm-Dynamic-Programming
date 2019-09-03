package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class StockBuySellProblem {
  public static void main(String[] args) {
    int[] arr = {100, 180, 260, 310, 40, 535, 695};
    System.out.println(findMaxBuySell(arr));

  }
  public static Map<Integer,Integer> findMaxBuySell(int[] arr){
    Stack<Integer> stack = new Stack<>();
    Map<Integer,Integer> map = new TreeMap<>();
    for(int i =arr.length-1;i>=0;i--){
      if(!stack.isEmpty()){
        if(stack.peek()<arr[i]){
          map.put(i+1,i+stack.size());
          stack = new Stack<>();
          stack.push(arr[i]);
        }else{
          if(i==0){
            map.put(i,stack.size());
          }
          stack.push(arr[i]);
        }
      }else{
        stack.push(arr[i]);
      }
    }

    return map;
  }
}
