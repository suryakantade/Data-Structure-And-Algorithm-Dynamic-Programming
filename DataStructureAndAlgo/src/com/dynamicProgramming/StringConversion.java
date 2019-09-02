package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/check-possible-transform-one-string-another/
public class StringConversion {

  public static void main(String[] args) {
    StringConversion conversion = new StringConversion();
    System.out.println(conversion.isConversionPossible("daBcd", "ABC"));
    System.out.println(conversion.isConversionPossible("argaju", "RAJ"));
    System.out.println(conversion.isConversionPossible("ABcd", "BCD"));
  }

  //s1 = daBcd s2 = ABC
  public boolean isConversionPossible(String s1, String s2) {
    for (Character c : s1.toCharArray()) {
      if ((int) c <= 90 && !s2.contains(""+c)) {
        return false;
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      for (int j = 0; j < s1.length(); j++) {
        if (("" + s1.charAt(j)).toUpperCase().equals("" + s2.charAt(i))) {
          i++;
          //j++;
        }
        if(i==s2.length()){
          return true;
        }
      }
      return false;
    }
    return false;
  }
}
