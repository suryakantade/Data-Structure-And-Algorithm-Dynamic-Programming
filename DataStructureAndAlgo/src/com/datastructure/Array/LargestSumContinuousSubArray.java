package com.datastructure.Array;

public class LargestSumContinuousSubArray {
  public static void main(String[] args) {
    int[] arr = {-2, -3, 4, -1, -2, 1, 5,-1,2, -3};
    System.out.println(largestSum(arr));
  }

  //{-2, -3, 4, -1, -2, 1, 5, -3}
  public static int largestSum(int[] arr){
    int curSum =0;
    int maxSum =0;
    for (int i =0;i<arr.length;i++){
      curSum += arr[i];
      if(curSum<0){
        curSum =0;
      }
      if(curSum >maxSum){
        maxSum = curSum;
      }
    }
    return maxSum;
  }
}
