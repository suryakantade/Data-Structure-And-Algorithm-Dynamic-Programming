package com.datastructure.Binarytree;

import java.util.Arrays;

public class InOrderPreOrderToPostOrder {
  public static void main(String[] args) {
    int[] inorder = {4, 2, 5, 1, 3, 6};
    int[] preorder = {1, 2, 4, 5, 3, 6};
    findPOstOrder(inorder, preorder, preorder.length);
  }

  public static void findPOstOrder(int[] inOrder, int[] preOrder, int size) {
    int inorderRootPos = search(inOrder, preOrder[0], size);
    if (inorderRootPos != 0) {
      findPOstOrder(inOrder, Arrays.copyOfRange(inOrder, 1, size), inorderRootPos);
    }
    if (inorderRootPos != size - 1) {
      findPOstOrder(Arrays.copyOfRange(inOrder, inorderRootPos + 1, size),
          Arrays.copyOfRange(preOrder, inorderRootPos + 1, size), size - inorderRootPos - 1);
    }
    System.out.println(preOrder[0]);

  }

  public static int search(int[] inOrder, int number, int size) {
    for (int i = 0; i < size; i++) {
      if (inOrder[i] == number) {
        return i;
      }
    }
    return -1;
  }
}
