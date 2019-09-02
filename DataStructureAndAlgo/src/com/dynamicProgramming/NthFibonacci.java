package com.dynamicProgramming;

//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
public class NthFibonacci {

  public static void main(String[] args) {
    NthFibonacci n = new NthFibonacci();
    System.out.println(n.findNthFibonacci(4));
  }
  public int findNthFibonacci(int n){
    int first = 0;
    int next =1;
    for(int i = 2;i<=n;i++){
      int tmp = first+next;
      first = next;
      next = tmp;
    }
    return next;
  }
}
