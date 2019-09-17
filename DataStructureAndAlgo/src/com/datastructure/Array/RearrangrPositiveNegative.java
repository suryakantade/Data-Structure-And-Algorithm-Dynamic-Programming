package com.datastructure.Array;

import java.util.Arrays;

//https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/
public class RearrangrPositiveNegative {
  public static void main(String[] args) {
    int[] arr = {1,-1,-2,-8,9,0,-7};
    rearrange(arr);
    System.out.println(Arrays.toString(arr));
  }
  //1,-1,2,3,7,-5,-6
  public static void rearrange(int[] arr){
    int index =0;
    for (int i =0;i<arr.length;i++){
      if(arr[i]<0){
        while (index==i || arr[index]<0)
          index++;
        int tmp = arr[index];
        arr[index] = arr[i];
        arr[i] = tmp;
      }
    }
  }
}
