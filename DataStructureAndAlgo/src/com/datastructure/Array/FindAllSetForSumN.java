package com.datastructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllSetForSumN {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5, -2,-1};
    List<int[]> lis = findSubSet(arr, 3);
    for(int[] arr1: lis){
      System.out.println(Arrays.toString(arr1));
    }
  }
  public static List<int[]> findSubSet(int[] arr , int k){
    List<int[]> lis = new ArrayList<>();
    for(int i =0;i<arr.length;i++){
      for(int j = i;j<arr.length;j++){
        int[] arr2 = findSet(arr, i, j, k);
        if(arr2 != null) {
          lis.add(arr2);
        }
      }
    }
    return lis;
  }
  public static int[] findSet(int[] arr, int start, int end, int k){
    int sum = 0;
    int[] arr1 = new int[end-start+1];
    for(int i =start;i<=end;i++){
      sum+=arr[i];
      arr1[i-start]=arr[i];
    }
    if(k == sum){
     return arr1;
    }
    return null;
  }
}
