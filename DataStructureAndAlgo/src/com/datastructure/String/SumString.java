package com.datastructure.String;

public class SumString {
  public static void main(String[] args) {

  }


  //122436
//  public static boolean isSumString(String s) {
//    int startIndex = 0;
//    int endIndex = 1;
//
//    for (int i = 0; i < s.length(); i++) {
//      for (int j = i + 1; j < s.length(); j++) {
//        if (isSum(s, Integer.parseInt(s.substring(startIndex, i)),
//            Integer.parseInt(s.substring(endIndex, j)), j)) {
//        //  if (j) {
//
//          }
//        }else {
//          return false;
//        }
//      }
//    }
//  }

  public static boolean isSum(String s, int i, int j, int startIndex) {
    for (int m = startIndex; m < s.length(); m++) {
      if (i + j == Integer.parseInt(s.substring(startIndex, m))) {
        return true;
      }
    }
    return false;
  }
}
