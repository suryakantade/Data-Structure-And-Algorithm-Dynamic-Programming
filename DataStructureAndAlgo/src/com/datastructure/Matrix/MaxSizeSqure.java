package com.datastructure.Matrix;

public class MaxSizeSqure {
  public static void main(String[] args) {
    int[][] arr = {{1, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 1, 1}};
    findBiggestMatrix(arr);
  }

  public static int findBiggestMatrix(int[][] arr) {
    int[][] copyMat = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr[0].length; i++) {
      copyMat[0][i] = arr[0][i];
    }
    for (int i = 0; i < arr.length; i++) {
      copyMat[i][0] = arr[i][0];
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[i].length; j++) {
        if (arr[i][j] == 1) {
          copyMat[i][j] = Math.min(Math.min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1])+1;
        } else {
          copyMat[i][j] = 0;
        }
      }
    }
    int max = 0;
    int maxI = 0;
    int maxJ = 0;
    for (int i = 0; i < copyMat.length; i++) {
      for (int j = 0; j < copyMat[0].length; j++) {
        if (copyMat[i][j] > max) {
          max = copyMat[i][j];
          maxI = i;
          maxJ = j;
        }
      }
    }
    System.out.println(max + "  i>>> " + maxI + "  maxj >> " + maxJ);
    return max;
  }
}
