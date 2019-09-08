package com.datastructure.Array;

import java.util.Arrays;

public class MoveAllZerosToEodArray {
  public static void main(String[] args) {
      int[] arr = {1,0,1,0,2,0,0,3,0,0,33,0,0};
      moveZeroToEnd(arr);
    System.out.println(Arrays.toString(arr));
  }
  public static void moveZeroToEnd(int[] arr){
    int lastZeroPos = arr.length-1;
    for (int i=0;i<lastZeroPos;i++){
      if(arr[i]==0){
        while (arr[lastZeroPos]==0){
          lastZeroPos--;
        }
        int tmp =arr[i];
        arr[i]=arr[lastZeroPos];
        arr[lastZeroPos]=tmp;
      }
      while (arr[lastZeroPos]==0){
        lastZeroPos--;
      }
    }
  }
}
