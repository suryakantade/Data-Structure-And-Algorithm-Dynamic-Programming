package com.datastructure.Matrix;


//https://www.geeksforgeeks.org/sum-middle-row-column-matrix/
public class MidRowColumnSum {
  public static void main(String[] args) {
    int mat[][] = {{2, 5, 7},
                  {3, 7, 2},
                  {5, 6, 9}};
    findMidMaxMin(mat);
  }

  public static void findMidMaxMin(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr[0].length; i++) {
      sum += arr[arr.length / 2][i];
    }
    System.out.println(sum);
    sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i][arr[0].length / 2];
    } System.out.println(sum);
  }
}
