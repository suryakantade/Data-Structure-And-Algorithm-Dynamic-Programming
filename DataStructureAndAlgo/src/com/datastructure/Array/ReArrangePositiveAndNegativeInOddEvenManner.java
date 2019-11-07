package com.datastructure.Array;

import java.util.Arrays;

public class ReArrangePositiveAndNegativeInOddEvenManner {
  public static void main(String[] args) {
    int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    //[-1, -3, -7, 4, 5, 6, 2, 8, 9]
    //9, -7, 8, -3, 5, -1, 2, 4, 6
    rearrange2(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void rearrange(int[] arr) {
    ArrangePositiveAndNegative.arrange(arr);
    int negStart = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0 && negStart != i && arr[negStart] < 0) {
        int tmp = arr[i];
        arr[i] = arr[negStart];
        arr[negStart] = tmp;
        negStart += 2;
      }
    }
  }

  public static void rearrange2(int[] arr) {
    int lastOdd = 0;
    int lastEven = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 0 && arr[i] < 0) {
        placeInNextPropPlace(arr, i);
      }else if(i%2==1&&arr[i]>=0){
        placeInNextPropPlace(arr, i);
      }
    }
  }

  public static void placeInNextPropPlace(int[] arr, int index) {
    int tmpIndex = index;
    if (index % 2 == 0 && arr[index] < 0) {
      tmpIndex++;
      while(arr[tmpIndex] < 0){
        tmpIndex=tmpIndex+2;
      }
      int tmp = arr[index];
      arr[index] = arr[tmpIndex];
      arr[tmpIndex]=tmp;
    }else{
      tmpIndex++;
      while(tmpIndex<arr.length && arr[tmpIndex] >= 0){
        tmpIndex=tmpIndex+2;
      }
      if(tmpIndex<arr.length) {
        int tmp = arr[index];
        arr[index] = arr[tmpIndex];
        arr[tmpIndex] = tmp;
      }
    }
  }
}
