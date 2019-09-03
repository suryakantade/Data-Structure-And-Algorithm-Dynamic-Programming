package com.datastructure.Matrix;

public class TransposeOfMatrix {
  public static void main(String[] args) {
    int arr[][] = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
    arr= findTransPose(arr);

    System.out.print("Result matrix is \n");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public static int[][] findTransPose(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr[i].length; j++) {
        int tmp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = tmp;
      }
    }
    return arr;
  }
}
