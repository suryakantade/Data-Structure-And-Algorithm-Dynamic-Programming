package com.datastructure.Matrix;

//https://www.geeksforgeeks.org/maximum-path-sum-matrix/
public class MaximumPathSumInMatrix {

  public static void main(String[] args) {
    int mat[][] =
        {{10, 10, 2, 0, 20, 4},
            {1, 0, 0, 30, 2, 5},
            {0, 10, 4, 0, 2, 0},
            {1, 0, 2, 20, 0, 4}};
    int max = 0;
    for (int i = 0; i < mat[0].length; i++) {
      int res = intFindMaxSumPath(mat, 0, i);
      if(res>max){
        max=res;
      }
    }
    System.out.println(max);
  }

  public static int intFindMaxSumPath(int[][] arr, int row, int column) {
    int max = Math.max(Math.max((isValidRange(arr, row + 1, column) ?
        intFindMaxSumPath(arr, row + 1, column) :
        Integer.MIN_VALUE), isValidRange(arr, row + 1, column - 1) ?
        intFindMaxSumPath(arr, row + 1, column - 1) :
        Integer.MIN_VALUE), isValidRange(arr, row + 1, column + 1) ?
        intFindMaxSumPath(arr, row + 1, column + 1) :
        Integer.MIN_VALUE);
    if (max == Integer.MIN_VALUE) {
      max = 0;
    }
    return arr[row][column] + max;
  }

  public static boolean isValidRange(int[][] arr, int x, int y) {
    if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
      return false;
    }
    return true;
  }
}
