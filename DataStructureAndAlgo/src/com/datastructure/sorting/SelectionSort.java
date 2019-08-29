package com.datastructure.sorting;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 4;
    arr[1] = 2;
    arr[2] = -2;
    arr[3] = 5;
    arr[4] = -6;
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (min > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr));

  }
}
