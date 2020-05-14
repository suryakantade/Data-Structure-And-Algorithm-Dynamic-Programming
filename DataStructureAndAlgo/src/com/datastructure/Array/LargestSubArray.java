package com.datastructure.Array;

public class LargestSubArray {
  public static void main(String[] args) {
    int[] arr= {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(getLargestSubArray(arr));
  }

  public static int getLargestSubArray(int[] arr){
    int max = 0;
    int maxFromLastMax = 0;
    for (int i = 0; i<arr.length;i++){
      maxFromLastMax+=arr[i];
      if(maxFromLastMax<0){
        maxFromLastMax=0;
      }
      if(max<maxFromLastMax){
        max = maxFromLastMax;
      }
    }
    return max;
  }
}
