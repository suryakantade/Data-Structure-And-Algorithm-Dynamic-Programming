package com.datastructure.String;

import java.util.HashSet;
import java.util.Set;

public class StringPermutationMyWay {
  public static void main(String[] args) {
    System.out.println(findStringPermutation("ABCD"));

  }
  //ABCD,ACBD,ADCB,ABDC
  public static Set<String> findStringPermutation(String input){
    Set<String> lis = new HashSet<>();
    for (int i =0;i<input.length();i++){
      for(int j=1;j<input.length();j++){
        lis.addAll(swapFrom(input, j));
      }
      if(i<input.length()-1) {
        input = swap(input, 0, i + 1);
      }
    }
    return lis;
  }
  public static Set<String> swapFrom(String input, int swapFrom){
    Set<String> lis = new HashSet<>();
    for(int i =swapFrom;i<input.length();i++){
      String a = swap(input, swapFrom,i);
      System.out.println(a);
      lis.add(a);
    }
    return lis;
  }
  public static String swap(String toBeSwaped, int indexToBeSwaped, int indexWithSwap) {
    char[] arr = toBeSwaped.toCharArray();
    char tmp = arr[indexToBeSwaped];
    arr[indexToBeSwaped] = arr[indexWithSwap];
    arr[indexWithSwap] = tmp;
    return new String(arr);
  }

}
