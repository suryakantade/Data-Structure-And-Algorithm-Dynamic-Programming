package com.datastructure.Array;

public class MinNoOfSwapToSort {
  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 1};
    System.out.println(noOfSwap(arr));
  }

  // 4 3 2 1
  public static int noOfSwap(int[] arr) {

    int minIndex = 0;
    int count = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      if (!isSorted(arr)) {
        int min = Integer.MAX_VALUE;
        for (int j = i; j < arr.length ; j++) {
          if (min > arr[j]) {
            min = arr[j];
            minIndex = j;
          }
        }
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
        count++;
      }
    }
    return count;
  }


  public static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
