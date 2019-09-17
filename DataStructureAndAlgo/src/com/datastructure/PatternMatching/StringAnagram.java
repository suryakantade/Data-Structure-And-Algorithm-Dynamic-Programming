package com.datastructure.PatternMatching;

//https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
public class StringAnagram {
  public static void main(String[] args) {
    char[] mainarr={'a','b','c','d'};
    char[] pattern = {'d','b','c'};
    System.out.println(isFound(mainarr,pattern));
  }

  public static Boolean isFound(char[] main, char[] pattern) {
    int[] mainTemp = new int[256];
    int[] patternTemp = new int[256];
    for (int i = 0; i < pattern.length; i++) {
      mainTemp[main[i]]++;
      patternTemp[pattern[i]]++;
    }
    if(isSame(mainTemp,patternTemp)){
      return true;
    }
    for (int i = pattern.length; i < main.length; i++) {
      mainTemp[main[i]]++;
      mainTemp[main[i-pattern.length]]--;
      if(isSame(mainTemp,patternTemp)){
        return true;
      }
    }
    return false;
  }

  public static Boolean isSame(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
}
