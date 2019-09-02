package com.dynamicProgramming;

public class NthCatalanNo {

  public static void main(String[] args) {

  }
  public int getNthCatalan(int n){
    if(n==1){
      return 1;
    }
    int result = 0;
    for(int i = 0;i<n;i++){
      result+=getNthCatalan(i)*getNthCatalan(n-i-1);
    }
    return result;
  }
}
