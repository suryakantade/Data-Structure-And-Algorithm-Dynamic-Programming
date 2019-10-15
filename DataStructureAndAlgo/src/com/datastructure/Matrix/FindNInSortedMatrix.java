package com.datastructure.Matrix;

import java.util.Arrays;

public class FindNInSortedMatrix {

  public static void main(String[] args) {
     int[][] arr = {{1, 9, 10},{2,10,21},{4,11,22}};
    System.out.println(Arrays.toString(findCordinate(arr,11)));
  }

  public static int[] findCordinate(int[][] arr, int n) {
    int i = 0;
    int j = arr[i].length - 1;
    while (i >= 0 && i < arr.length && j >= 0 && j < arr[i].length) {
      if (arr[i][j] == n) {
        return new int[] {i, j};
      } else if (arr[i][j] < n) {
        i++;
      } else {
        j--;
      }
    }
    return new int[]{-1};
  }
}
