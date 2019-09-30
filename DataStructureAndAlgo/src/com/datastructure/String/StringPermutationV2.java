package com.datastructure.String;

import java.util.HashSet;
import java.util.Set;

public class StringPermutationV2 {
  public static void main(String[] args) {
    System.out.println(findPermutation("ABC".toCharArray()));
  }

  //a b c
  //a c b
  //
  public static Set<String> findPermutation(char[] arr) {
    Set<String> stringSet = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      stringSet.add(swap(arr, 0, i));
      stringSet.addAll(traverseAndSwap(arr, i + 1));
      swap(arr, 0, i);
    }
    return stringSet;
  }

  public static Set<String> traverseAndSwap(char[] arr, int currentIndex) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < arr.length&&currentIndex< arr.length; i++) {
      set.add(swap(arr, currentIndex, i));
      swap(arr, currentIndex, i);
    }
    return set;
  }

  public static String swap(char[] arr, int index, int indexToBeSwappedWith) {
    char tmp = arr[index];
    arr[index] = arr[indexToBeSwappedWith];
    arr[indexToBeSwappedWith] = tmp;
    return new String(arr);
  }
}
