package com.datastructure.Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
public class RotateSqureMatrixBy90 {
  public static void main(String[] args) {
    int mat[][] =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
    rotateMatrix(mat);
    for (int i = 0; i < mat.length; i++)
    {
      for (int j = 0; j < mat[0].length; j++)
        System.out.print( mat[i][j] + " ");
      System.out.print("\n");
    }
  }
  public static void rotateMatrix(int[][] arr){
    Stack<int[]> stack = new Stack<>();
    for(int column = 0;column<arr[0].length;column++){
      int[] tmp = new int[arr[0].length];
      for (int row =0;row<arr.length;row++){
        tmp[row] = arr[row][column];
      }
      stack.push(tmp);
    }
    int count =0;
    while(!stack.isEmpty()){
      int[] arrTemp = stack.pop();
      arr[count++]=arrTemp;
    }
  }
  public static int[] reverse(int[] arr){
    for(int i =0;i<arr.length/2;i++){
      int tmp = arr[0];
      arr[0]=arr[arr.length-1-i];
      arr[arr.length-1-i]=tmp;
    }
    return arr;
  }
}
