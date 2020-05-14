package com.datastructure.Array;

import java.util.Arrays;

public class SegregateEvenOdd {
  public static void main(String[] args) {
    int[] arr = new int[]{1,9,5,3,2,6,7,11};
    segregate(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void segregate(int[] arr) {
    int ptr = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0 && ptr != i) {
        int tmp = arr[ptr];
        arr[ptr] = arr[i];
        arr[i] = tmp;
        ptr++;
      }
    }
  }
}
