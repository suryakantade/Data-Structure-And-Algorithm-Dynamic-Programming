package com.datastructure.Matrix;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueBinaryRows {

  public static void main(String[] args) {
    int[][] arr = {{1, 0, 0, 1},{1,1,1,1},{1,0,0,1},{1,1,1,1}};
    findUnique(arr);
  }

  public static void findUnique(int[][] arr){
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<arr.length;i++){
      int sum=0;
      String s = "";
      for (int j =0;j<arr[i].length;j++){
        sum=(sum<<1)+arr[i][j];
        s+=" "+arr[i][j];
      }
      if(!map.containsKey(sum)){
        System.out.println(s);
        map.put(sum,sum);
      }
    }
  }
}
