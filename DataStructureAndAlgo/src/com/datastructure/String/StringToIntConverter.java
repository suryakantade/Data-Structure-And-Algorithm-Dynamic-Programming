package com.datastructure.String;

public class StringToIntConverter {
  public static void main(String[] args) {
    String s ="123";
    int total = 0;
    for (int i =0;i<s.length();i++)
      total+=Math.pow(10,(s.length()-1-i))*(((int)s.charAt(i)-48));
    System.out.println(total);
  }
}
