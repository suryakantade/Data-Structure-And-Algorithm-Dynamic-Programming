package com.datastructure.Binarytree;

//https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
public class PossibleTreesFromInOrder {

  public static void main(String[] args) {
    PossibleTreesFromInOrder binaryTree = new PossibleTreesFromInOrder();
    int[] input= {4, 5, 7};

    binaryTree.findPossibleCombination(input, "");

  }

  public void findPossibleCombination(int[] arr, String prefix) {
    if (arr.length == 0) {
      System.out.println(prefix);
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      int[] tempArr = new int[arr.length - 1];
      int count = 0;
      for (int j = 0; j < arr.length; j++) {
        if (i != j) {
          tempArr[count] = arr[j];
          count++;
        }
      }
      findPossibleCombination(tempArr, prefix + " " + arr[i]);
    }
  }
}
