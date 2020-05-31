package zztest;

import java.util.Scanner;

public class TestNew {


  public static void main(String[] args) {
    /*int[][] arr = initializeArray(5,10);

    Boolean shouldIterate= true;
    while(shouldIterate) {
      Scanner scanner = new Scanner(System.in);
      int ip = scanner.nextInt();
      allocateAnother(arr, ip);
      printArray(arr);*/

    System.out.println(getPower(5, 2));
  }


  public static int getPower(int no, int pow) {

    if (pow == 1) {
      return no;
    }
    if (pow == 0) {
      return 1;
    }

    int tmp = 0;
    for (int i = 0; i < no; i++) {
      tmp += no;
    }
    if(pow>1) {
      return getPower(tmp, --pow);
    }
    return tmp;
  }




  public static int[][] initializeArray(int x, int y) {
    int[][] arr = new int[x][y];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = 0;
      }
    }
    return arr;
  }


  public static void printArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(" " + arr[i][j]);
      }
      System.out.println("\n");
    }
  }

  /*1 1 1 0 1 1 1 1 1 0 [5]  5
    0 0 0 0 0 0 0 0 0 0 0 []
    0 0 0 0 0 0 0 0 0 0 0 []
  3
  4
  2*/

  public static void allocateAnother(int[][] arr, int ip) {
    f:
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (checkIsNextNElementFree(arr[i], j, ip)) {
          markAllocated(arr[i], j, ip);
          break f;
        }
      }
    }
  }

  public static boolean checkIsNextNElementFree(int[] arr, int startingPoint, int n) {
    if (arr.length - startingPoint >= n) {
      for (int i = startingPoint; i < startingPoint + n; i++) {
        if (arr[i] == 1) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public static void markAllocated(int[] arr, int startingPoint, int n) {
    if (arr.length - startingPoint >= n) {
      for (int i = startingPoint; i < startingPoint + n; i++) {
        arr[i] = 1;
      }
    }
  }
}

