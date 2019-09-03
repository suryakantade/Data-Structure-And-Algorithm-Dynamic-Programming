package com.datastructure.Matrix;

public class RotateMatrix {
  public static void main(String[] args) {
    int a[][] = { {1, 2, 3, 4},
                  {5, 6, 7, 8},
                  {9, 10, 11, 12},
                  {13, 14, 15, 16} };
rotateMatrix(a,0,0);
    for (int i = 0; i < a.length; i++)
    {
      for (int j = 0; j < a[0].length; j++)
        System.out.print( a[i][j] + " ");
      System.out.print("\n");
    }
  }

  public static void rotateMatrix(int[][] arr, int x, int y){
    if(x*2 >= arr.length || y*2 >=arr[x].length){
      return;
    }
    int lastTopRowElement = 0;
    for(int i = y;i<arr[0].length-y;i++){
      int tmp = arr[x][i];
      arr[x][i] = lastTopRowElement;
      lastTopRowElement = tmp;
    }
    for(int i =x+1;i<arr.length-x;i++){
      int tmp = arr[i][arr[0].length-1-y];
      arr[i][arr[0].length-1-y]=lastTopRowElement;
      lastTopRowElement=tmp;
    }
    for(int i =arr[0].length-1-y-1;i>=y;i--){
      int tmp = arr[arr.length-x-1][i];
      arr[arr.length-x-1][i] = lastTopRowElement;
      lastTopRowElement = tmp;
    }
    for (int i= arr.length-1-x-1;i>=x;i--){
      int tmp = arr[i][y];
      arr[i][y] = lastTopRowElement;
      lastTopRowElement=tmp;
    }
    x++;y++;
    rotateMatrix(arr,x,y);
  }
}
