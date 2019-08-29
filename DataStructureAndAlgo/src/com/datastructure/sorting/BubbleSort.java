package com.datastructure.sorting;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {1, 4, -1, -3, -5};
    for (int i = arr.length - 1; i >= 0; i--) {
      for (int j = 0;j<i;j++){
        swap(arr, j,j+1);
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  public static void swap(int[] arr, int source, int destination) {
    if (arr[source] == arr[destination]) {
      return;
    }
    if (arr[source] > arr[destination]) {
      int temp = arr[source];
      arr[source] = arr[destination];
      arr[destination] = temp;
    }
  }
}
