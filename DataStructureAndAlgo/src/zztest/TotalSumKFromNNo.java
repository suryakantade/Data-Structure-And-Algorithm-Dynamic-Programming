package zztest;

import java.util.Stack;

public class TotalSumKFromNNo {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    int[] arr = {1, 2, 3, 4, 6};
    int sum = 6;
    boolean isMatch = isSumMatch(arr, sum, 3, 0, stack);
    System.out.println(stack);
  }

  public static boolean isSumMatch(int[] arr, int sum, int noOfElementstoSum, int i,
      Stack<Integer> stack) {
    if (sum == 0) {
      return true;
    }
    if (sum < 0 || noOfElementstoSum == 0 || i >= arr.length) {
      return false;
    }
    if (sum - arr[i] >= 0) {
      stack.push(arr[i]);
      if (isSumMatch(arr, sum - arr[i], noOfElementstoSum - 1, i + 1, stack)) {
        return true;
      }
    }
    stack.pop();
    return isSumMatch(arr, sum, noOfElementstoSum, i + 1, stack);
  }


}
