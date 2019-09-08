package com.datastructure.Array;


import java.util.Arrays;

//https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
public class ArrangePositiveAndNegative {
  public static void main(String[] args) {
    int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    arrange(arr);
    System.out.println(Arrays.toString(arr));

  }

  public static void arrange(int arr[]) {
    int lastPositiveIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        if (i != lastPositiveIndex) {
          swap(arr, i, lastPositiveIndex);
        }
        lastPositiveIndex++;
      }
    }
  }

  public static void swap(int[] arr, int indexNeg, int lastNegIndex) {
    int tmp = arr[indexNeg];
    arr[indexNeg] = arr[lastNegIndex];
    arr[lastNegIndex] = tmp;
  }
}
