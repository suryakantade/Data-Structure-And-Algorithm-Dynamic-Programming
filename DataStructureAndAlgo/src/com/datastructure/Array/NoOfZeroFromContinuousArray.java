package com.datastructure.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfZeroFromContinuousArray {
  public static void main(String[] args) {
    int[] arr = {6, 3, -1, -3, 4,0, -2, 2,
        4, 6, -12, -7};
    System.out.println("no of zero : "+ noOfZero(arr));
  }

  // -1 1 0 -2 3
  public static int noOfZero(int[] arr){
    Map<Integer, List<Integer>> sumMap = new HashMap<>();
    int sum =0;
    int count =0;
    for (int i = 0;i<arr.length;i++){
      sum+=arr[i];
      if(arr[i]==0){
        count++;
      }
      if(null != sumMap.get(sum)){
        count+=sumMap.get(sum).size();
        sumMap.get(sum).add(i);
      }else{
        List<Integer> indexes = new ArrayList<>();
        indexes.add(i);
        sumMap.put(sum, indexes);
      }
    }
    return count;
  }
}
