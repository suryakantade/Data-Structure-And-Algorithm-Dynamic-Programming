package com.datastructure.Matrix;


//https://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
public class NOOfRectangleIslands {
  public static void main(String[] args) {
    char mat[][] = {{'O', 'X', 'O'},
        {'X', 'X', 'O'},
        {'X', 'X', 'O'},
        {'O', 'O', 'X'},
        {'O', 'O', 'X'},
        {'X', 'X', 'O'}
    };
    System.out.println(findRectangleIlands(mat));
  }

  public static int findRectangleIlands(char[][] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 'X') {
          if ((i == 0 || arr[i - 1][j] == 'O') && (j == 0 || arr[i][j - 1] == 'O')) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
