package com.datastructure.Matrix;

public class NoOfIlands {
  public static void main(String[] args) {
    int mat[][] =
        {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};
    System.out.println(findNoOfIlands(mat));
  }

  public static int findNoOfIlands(int[][] arr) {
    int[][] visitedArr = new int[arr.length][arr[0].length];
    int count =0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (visitedArr[i][j] == 0 && arr[i][j] == 1) {
          visitedArr[i][j] = 1;
          findNeighbourAndMark(arr,visitedArr,i,j);
          count++;
        }
      }
    }
    return count;
  }

  public static void findNeighbourAndMark(int[][] mainArr, int[][] visitedArr, int x, int y) {
    if (isNotOutOfRange(mainArr,x+1,y,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x+1, y );
    }
    if (isNotOutOfRange(mainArr,x+1,y+1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x + 1, y+1);
    }
    if (isNotOutOfRange(mainArr,x,y+1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x, y+1);
    }
    if (isNotOutOfRange(mainArr,x-1,y+1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x-1, y+1);
    }
    if (isNotOutOfRange(mainArr,x-1,y,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x-1, y);
    }
    if (isNotOutOfRange(mainArr,x-1,y-1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x-1, y-1);
    }
    if (isNotOutOfRange(mainArr,x,y-1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x, y-1);
    }
    if (isNotOutOfRange(mainArr,x+1,y-1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x+1, y-1);
    }
  }

  public static boolean isNotOutOfRange(int[][] arr, int x, int y, int[][] visitedArr) {
    if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && visitedArr[x][y] != 1
        && arr[x][y] == 1) {
      visitedArr[x][y] = 1;
      return true;
    }
    return false;
  }
}
