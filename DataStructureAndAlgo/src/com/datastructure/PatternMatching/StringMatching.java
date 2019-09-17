package com.datastructure.PatternMatching;

import java.util.Arrays;

public class StringMatching {
  public static void main(String[] args) {
    char[] mainArr = {'a', 'b', 'c'};
    char[] pattern = {'b','b'};
    System.out.println(isExists(mainArr, pattern));

  }

  public static Boolean isExists(char[] mainArr, char[] pattern) {
    if (pattern.length > mainArr.length) {
      return false;
    }
    int i = 0;
    while (i + pattern.length <= mainArr.length) {
      if (isSame(Arrays.copyOfRange(mainArr, i, i + pattern.length), pattern)) {
        return true;
      }
      i++;
    }
    return false;
  }

  public static Boolean isSame(char[] a, char[] b) {
    if (a.length != b.length) {
      return false;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
}
