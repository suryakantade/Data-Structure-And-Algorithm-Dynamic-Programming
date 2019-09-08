package com.datastructure.Matrix;

//https://www.geeksforgeeks.org/center-element-of-matrix-equals-sums-of-half-diagonals/
public class CenterElementEqualsSumOfHalfDiagonal {
  public static void main(String[] args) {
    int a[][] = { { 2, 9, 1, 4, -2},
                  { 6, 7, 2, 11, 4},
                  { 4, 2, 9, 2, 4},
                  { 1, 9, 2, 4, 4},
                  { 0, 2, 4, 2, 5} };
    System.out.println(checkSumOfHalfDiagonal(a));
  }

  public static boolean checkSumOfHalfDiagonal(int[][] arr) {
    int sum = 0;
    int middleElement = arr[arr.length / 2][arr.length / 2];
    for (int i = 0; i < arr.length / 2; i++) {
      sum += arr[i][i];
    }
    if (sum != middleElement) {
      return false;
    }
    sum = 0;
    for (int i = arr.length - 1; i > arr.length / 2; i--) {
      sum += arr[i][i];
    }
    if (sum != middleElement) {
      return false;
    }
    sum = 0;
    for (int i = arr.length - 1; i > arr.length / 2; i--) {
      sum += arr[arr.length - 1 - i][i];
    }
    if (sum != middleElement) {
      return false;
    }
    sum = 0;
    for (int i = 0; i < arr.length / 2; i++) {
      sum += arr[arr.length - 1 - i][i];
    }
    if (sum != middleElement) {
      return false;
    }
    return true;
  }
}
