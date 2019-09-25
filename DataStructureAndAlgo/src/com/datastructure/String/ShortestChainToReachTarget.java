package com.datastructure.String;

import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
public class ShortestChainToReachTarget {
  public static void main(String[] args) {
    String[] arr = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
    System.out.println(getShortestChain(arr, "TOON", "PLEA"));
  }

  public static int getShortestChain(String[] arr, String input, String target) {
    Arrays.sort(arr);
    int targetIndex = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(target)) {
        targetIndex = i;
        break;
      }
    }
    if (targetIndex == -1) {
      return -1;
    }
    //{POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
    boolean left = true;
    boolean right = true;
    for (int i = 0; i < arr.length; i++) {
      if (targetIndex - i < 0 || (i != 0 && !isMatch(arr[targetIndex - i],
          arr[targetIndex - i + 1]))) {
        left = false;
      }
      if (targetIndex + i >= arr.length || (i != 0 && !isMatch(arr[targetIndex + i],
          arr[targetIndex + i - 1]))) {
        right = false;
      }
      if (left && isMatch(arr[targetIndex - i], input)) {
        return i;
      }
      if (right && isMatch(arr[targetIndex + i], input)) {
        return i;
      }
    }
    return -1;
  }

  public static boolean isMatch(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int index = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        index++;
      }
    }
    if (index > 1) {
      return false;
    }
    return true;
  }
}
