package com.datastructure.Matrix;

public class ShiftMatrixKElements {

  public static void main(String[] args) {
    int a[][] = { {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16} };
    ShiftMatrix(a,2);
    for (int i = 0; i < a.length; i++)
    {
      for (int j = 0; j < a[0].length; j++)
        System.out.print( a[i][j] + " ");
      System.out.print("\n");
    }
  }

  public static void ShiftMatrix(int[][] arr, int n){
    for(int i =0;i<arr.length;i++){
      for (int j=1;j<=n;j++)
        arr[i]=rotateArr(arr[i]);
    }
    //return arr;
  }
  //1,2,3,4
  public static int[] rotateArr(int[] arr){
    int tmp =arr[0];
    for(int i =0;i<arr.length;i++){
      int tmp1 = arr[(i+1)%(arr.length)];
      arr[(i+1)%(arr.length)] = tmp;
      tmp = tmp1;
    }
    return arr;
  }
}
