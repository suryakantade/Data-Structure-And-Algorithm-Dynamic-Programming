package com.datastructure.Matrix;

import java.util.Arrays;

public class SortAMAtrix {
  public static void main(String[] args) {

  }

  public static void sort(int[][] arr) {
    int[] linearArr = new int[arr.length * arr[0].length];
    int counter = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        linearArr[counter++] = arr[i][j];
      }
    }
    Arrays.sort(linearArr);
    counter = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = linearArr[counter];
      }
    }
  }
}
