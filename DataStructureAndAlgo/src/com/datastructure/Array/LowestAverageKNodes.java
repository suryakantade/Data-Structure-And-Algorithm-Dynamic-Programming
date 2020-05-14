package com.datastructure.Array;


//https://www.geeksforgeeks.org/find-subarray-least-average/
public class LowestAverageKNodes {

  public static void main(String[] args) {
    int[] arr = {3, 7, 90, 20, 10, 50, 40};
    System.out.println(lowestAvg(arr, 3));
  }

  //{3, 7, 90, 20, 10, 50, 40}, k = 3
  public static int lowestAvg(int[] arr, int k) {
    int avg = 0;
    int minAvg = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i < k) {
        sum += arr[i];
        avg = sum / (i + 1);
        if (i == k - 1) {
          minAvg = avg;
        }
      } else {
        avg = (sum = (sum - arr[i - k] + arr[i])) / k;
        if (avg < minAvg) {
          minAvg = avg;
        }
      }
    }
    return avg;
  }
}
