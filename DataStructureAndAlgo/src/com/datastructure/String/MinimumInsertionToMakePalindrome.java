package com.datastructure.String;

// https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
public class MinimumInsertionToMakePalindrome {
  public static void main(String[] args) {
    String input = "adcdd";//addcdda
    System.out.println(minimumInsertion(input, 0, input.length()-1));
  }

  public static int minimumInsertion(String input, int startPoint, int endPoint) {

    if (startPoint == endPoint) {
      return 0;
    }
    if (startPoint > endPoint) {
      return Integer.MAX_VALUE;
    }
    if (startPoint == endPoint - startPoint) {
      return input.charAt(startPoint) == input.charAt(endPoint) ? 0 : 1;
    }
    if (input.charAt(startPoint) == input.charAt(endPoint)) {
      return minimumInsertion(input, startPoint + 1, endPoint - 1);
    } else {
      return 1 + (Math.min(minimumInsertion(input, startPoint + 1, endPoint),
          minimumInsertion(input, startPoint, endPoint - 1)));
    }
  }
}
