package com.datastructure.Matrix;

//https://www.geeksforgeeks.org/swap-major-minor-diagonals-square-matrix/
public class SwapMajorDiagonal {
  public static void main(String[] args) {
    int a[][] = { {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16} };
    swap(a);
    for (int i = 0; i < a.length; i++)
    {
      for (int j = 0; j < a[0].length; j++)
        System.out.print( a[i][j] + " ");
      System.out.print("\n");
    }

  }
  public static void swap(int[][] arr){
    int i = arr[0][0];
    arr[0][0] = arr[0][arr[0].length-1];
    arr[0][arr[0].length-1] = i;

    i = arr[arr.length-1][0];
    arr[arr.length-1][0] = arr[arr.length-1][arr[0].length-1];
    arr[arr.length-1][arr[0].length-1] = i;
  }
}
