package com.dynamicProgramming;

import java.util.Arrays;

public class ArrangeBiggestNumber {
  public static void main(String[] args) {
    int[] arr = {54, 546, 548, 60};
    System.out.println(generateBiggesArray(arr));
  }
  //m1: find max lentgth, add self to reach max length, sort then add
  //m2: find all possible permutation and find the max
  //m3: compare x and y with x+""+y>y+""+x?x:y

  public static String generateBiggesArray(int arr[]) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length ; j++) {
        if (compare(arr[j], arr[i])) {
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
        }
      }
    }
    return Arrays.toString(arr);
  }

  public static Boolean compare(int x, int y) {
    String xy = "" + x + y;
    String yx = "" + y + x;
    return Integer.parseInt(xy) > Integer.parseInt(yx) ? true : false;
  }
}
