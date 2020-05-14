package com.datastructure.Binarytree;

import java.util.Stack;

public class ArrayRepresentPreorderTraversal {
  public static boolean isIncreasing = false;

  public static void main(String[] args) {
    int[] i = {5, 4, 3, 6, 7, 8, 9};
    System.out.println(isPreOrder(i));
  }

  //5 4 3 6 2 7 8 9
  public static boolean isPreOrder(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (!stack.isEmpty()) {
        Integer pop = stack.peek();
        /*if (isIncreasing == true && pop > arr[i]) {
          return false;
        } else if (pop < arr[i]) {
          isIncreasing = true;
        }*/


        if (isIncreasing == false && pop < arr[i]) {
          isIncreasing = true;
        } else if (isIncreasing && pop > arr[i]) {
          return false;
        }
        stack.push(arr[i]);
      } else {
        stack.push(arr[i]);
      }
    }
    return true;
  }
}
