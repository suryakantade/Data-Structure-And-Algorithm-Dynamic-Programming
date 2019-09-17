package com.datastructure.String;

public class StringPermutation {

  public static void main(String[] args) {
    permutation("ABC", 0,"ABC".length()-1);
  }

  public static void permutation(String string, int start, int last) {
    if (start == last) {
      System.out.println(string);
    }
    for (int i = start; i <= last; i++) {
      string = swap(string, start, i);
      permutation(string, start + 1, last);
      string = swap(string, i, start);
    }
  }

  public static String swap(String toBeSwaped, int indexToBeSwaped, int indexWithSwap) {
    char[] arr = toBeSwaped.toCharArray();
    char tmp = arr[indexToBeSwaped];
    arr[indexToBeSwaped] = arr[indexWithSwap];
    arr[indexWithSwap] = tmp;
    return new String(arr);
  }
}
