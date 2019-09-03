package com.datastructure.Matrix;

public class MatrixSpiralTraversal {
  public static void main(String[] args) {
    int a[][] = {{1, 2, 3, 4, 5, 6},
                 {7, 8, 9, 10, 11, 12},
                 {13, 14, 15, 16, 17, 18}};
    spiralTraversal(a,0,0);

  }

  public static void spiralTraversal(int[][] arr, int row, int column) {

    if ((row * 2 >= arr.length) || (column * 2 >= arr[row].length)) {
      return;
    }

    //first row
    int tmpColumn = 0;
    for (int i = column; i < arr[row].length - column; i++) {
      System.out.println(arr[row][i]);
    }
    if ((row+1 * 2 >= arr.length) || (column * 2 >= arr[row].length)) {
      return;
    }
    //right column
    for (int i = row + 1; i < arr.length - row; i++) {
      System.out.println(arr[i][arr[row].length-column-1]);
    }
    if (((row+1) * 2 >= arr.length) || ((column+1) * 2 >= arr[row].length)) {
      return;
    }
    //last row
    for (int i = arr[row].length - 1 - column-1; i >= column; i--) {
      System.out.println(arr[arr.length - row - 1][i]);
    }
    //left column
    for (int i = arr.length - 1 - row - 1; i >= row + 1; i--) {
      System.out.println(arr[i][column]);
    }
    row++;
    column++;
    spiralTraversal(arr, row, column);
  }
}
