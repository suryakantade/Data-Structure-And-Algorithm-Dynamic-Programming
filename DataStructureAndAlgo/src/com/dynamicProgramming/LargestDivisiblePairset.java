package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestDivisiblePairset {
  public static void main(String[] args) {
    LargestDivisiblePairset l = new LargestDivisiblePairset();
    int[] arr = {18, 1, 3, 6, 13, 17}; // {10, 5, 3, 15, 20};
    Arrays.sort(arr);
    /*int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int res = l.largestDivisiblePair(arr, i + 1, arr[i]);
      if (count < res) {
        count = res + 1;
      }
    }
    System.out.println(count);*/
    System.out.println(l.largestDivisiblePairMethod2(arr));

  }

  //before calling this method we have to make sure that the array passed is sorted
  public int largestDivisiblePair(int[] arr, int startIndex, int num) {
    int count = 0;
    for (int i = startIndex; i < arr.length; i++) {
      if (arr[i] % num == 0) {
        int res = 1 + largestDivisiblePair(arr, i + 1, arr[i]);
        if (count < res) {
          count = res;
        }
      }
    }
    return count;
  }


  //method 2
  public int largestDivisiblePairMethod2(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] % arr[i] == 0) {
          if (null != map.get(arr[j]) && count <= map.get(arr[j])) {
            count = map.get(arr[j]) + 1;
          }
        }
      }
      map.put(arr[i], count == 0 ? ++count : count);
    }
    List<Integer> list = new ArrayList<Integer>(map.values());
    Collections.sort(list, Collections.reverseOrder());
    return list.get(0);
  }
}
