package com.datastructure.Array;


import java.util.Arrays;

//1 2 3 4 5 6 7
public class SplitArray {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    int k =2;
    for (int i =1;i<=k;i++){
      rotateLeft(arr);
    }
    System.out.println(Arrays.toString(arr));
  }
  public static void rotateLeft(int[] arr){
    int tmp = arr[0];
    for(int i = 1;i<arr.length;i++){
      arr[i-1]=arr[i];
    }
    arr[arr.length-1]=tmp;
  }
}
