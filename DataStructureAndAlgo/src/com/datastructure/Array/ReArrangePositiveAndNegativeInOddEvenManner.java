package com.datastructure.Array;

import java.util.Arrays;

public class ReArrangePositiveAndNegativeInOddEvenManner {
  public static void main(String[] args) {
    int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    //[-1, -3, -7, 4, 5, 6, 2, 8, 9]
    //9, -7, 8, -3, 5, -1, 2, 4, 6
    rearrange(arr);
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
}
