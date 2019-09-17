package com.datastructure.Backtracking;

//https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/
public class LandminesProblem {
  public static void main(String[] args) {
    int mat[][] =
    {
      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
      { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
    };
    findMinPath(mat);
  }

  public static void findMinPath(int[][] arr) {
    setSorrund(arr);
    int min = Integer.MAX_VALUE;
    for (int i = arr.length - 1; i >= 0; i--) {
      int[][] arrTraversed = new int[arr.length][arr[arr.length - 1].length];
      int res = findLeftColToRightColumn(arr, i, arr[i].length - 1, 0, arrTraversed);
      if (res < min) {
        min = res;
      }
    }
    System.out.println(min);
  }

  public static int findLeftColToRightColumn(int[][] arr, int x, int y, int count,
      int[][] arrTraversed) {
    if (y == 0) {
      return count;
    }
    if (!isValidNextStep(arr, x, y, arrTraversed)) {
      return Integer.MAX_VALUE;
    }
    arrTraversed[x][y] = 1;
    int res = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(
        Math.min(findLeftColToRightColumn(arr, x + 1, y, count, arrTraversed),
            findLeftColToRightColumn(arr, x, y + 1, count, arrTraversed)),
        findLeftColToRightColumn(arr, x + 1, y + 1, count, arrTraversed)),
        findLeftColToRightColumn(arr, x + 1, y - 1, count, arrTraversed)),
        findLeftColToRightColumn(arr, x - 1, y, count, arrTraversed)),
        findLeftColToRightColumn(arr, x, y - 1, count, arrTraversed)),
        findLeftColToRightColumn(arr, x - 1, y - 1, count, arrTraversed)),
        findLeftColToRightColumn(arr, x - 1, y + 1, count, arrTraversed));
    return res == Integer.MAX_VALUE?Integer.MAX_VALUE:1+res;
  }

  public static void setSorrund(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0) {
          if (isValid(arr, i - 1, j)) {
            arr[i - 1][j] = 7;
          }
          if (isValid(arr, i + 1, j)) {
            arr[i + 1][j] = 7;
          }
          if (isValid(arr, i, j - 1)) {
            arr[i][j - 1] = 7;
          }
          if (isValid(arr, i, j + 1)) {
            arr[i][j + 1] = 7;
          }
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 7) {
          arr[i][j] = 0;
        }
      }
    }
  }

  public static Boolean isValid(int[][] arr, int x, int y) {
    if (x < 0 || y < 0 || x >= arr.length || y >= arr[x].length || arr[x][y] == 0) {
      return false;
    }
    return true;
  }

  public static Boolean isValidNextStep(int[][] arr, int x, int y, int[][] arrTraversed) {
    if ((!isValid(arr, x, y)) || arrTraversed[x][y] == 1) {
      return false;
    }
    return true;
  }

  public static void setTraversedFalse(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = 0;
      }
    }
  }
}
