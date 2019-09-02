package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/given-large-number-check-subsequence-digits-divisible-8/
public class SequenceNumberDivisibleByEight {
  static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    getAllPermutation("1238", "");
    for (Integer i : list) {
      if (i % 8 == 0) {
        System.out.println(i + " is divisible by 8");
        break;
      }
    }
    System.exit(1);
  }

  // a s d f g
  public static void getAllPermutation(String s, String tmp) {
    if (!tmp.isEmpty()) {
      list.add(Integer.parseInt(tmp));
    }
    if (null == s || s.isEmpty()) {
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      getAllPermutation(s.substring(0, i) + s.substring(i + 1), tmp + s.charAt(i));
    }
  }

  //this method mentains sequence
  public Boolean isSequenceDivisibleByEight(Integer ip) {
    String s = ip.toString();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (Integer.parseInt(s.substring(i, j)) % 8 == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
