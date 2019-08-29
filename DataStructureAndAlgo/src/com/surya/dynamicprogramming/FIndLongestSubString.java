package com.surya.dynamicprogramming;

public class FIndLongestSubString {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    findLongestSubString("GeeksforGeeks", "geekss");
  }

  public static void findLongestSubString(String a, String b) {
    String longestString = null;
    for (int i = 0; i < a.length(); i++) {
      if (b.contains(a.substring(i))) {
        longestString = a.substring(i);
        break;
      } else if (b.contains(a.substring(0, a.length() - 1 - i))) {
        longestString = a.substring(0, a.length() - 1 - i);
        break;
      }
    }
    System.out.println(longestString);

  }

  //geeksforgeeks
  //ggeekss
  public boolean contains(String parentString, String childString) {
    // GeeksforGeeks
    StringBuilder sb = new StringBuilder();
    StringBuilder sbCopy = new StringBuilder();
    int iCopy = 0;
    for (int i = iCopy; i < childString.length(); i++) {
      for (int j = 0; j < parentString.length(); j++) {
        if (parentString.charAt(j) == childString.charAt(i)) {
          if (i >= childString.length() - 1) {
            return true;
          } else {
            i = i + 1;
            sb.append("" + childString.charAt(i));

          }
        }
      }
    }
    return true;
  }
}
