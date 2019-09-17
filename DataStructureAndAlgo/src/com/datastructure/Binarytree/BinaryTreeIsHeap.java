package com.datastructure.Binarytree;

public class BinaryTreeIsHeap {
  static int maxLength, minLength;
  TreeNode root;

  public BinaryTreeIsHeap(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {

    BinaryTreeIsHeap binaryTree = new BinaryTreeIsHeap(new TreeNode(1));
    binaryTree.root.setLeft(new TreeNode(2));
    binaryTree.root.setRight(new TreeNode(3));
    binaryTree.root.getLeft().setLeft(new TreeNode(4));
    binaryTree.root.getLeft().setRight(new TreeNode(5));

    binaryTree.root.getRight().setLeft(new TreeNode(6));
    binaryTree.root.getRight().setRight(new TreeNode(7));
    System.out.println(isHeap(binaryTree.root, 0));
  }

  public static Boolean isHeap(TreeNode root, int currentLength) {
    if (root == null) {
      if (BinaryTreeIsHeap.minLength == 0) {
        BinaryTreeIsHeap.minLength = currentLength;
      }
      if (BinaryTreeIsHeap.maxLength < currentLength) {
        BinaryTreeIsHeap.maxLength = currentLength;
      }
      if (BinaryTreeIsHeap.maxLength == BinaryTreeIsHeap.minLength
          || BinaryTreeIsHeap.maxLength - BinaryTreeIsHeap.minLength >= 1) {
        return Boolean.TRUE;
      }
    } else {
      if (BinaryTreeIsHeap.maxLength < currentLength) {
        BinaryTreeIsHeap.maxLength = currentLength;
      }
      if ((null != root.left && root.left.val < root.val) || (null != root.right
          && root.right.val < root.val)) {
        return Boolean.FALSE;
      }
      Boolean leftRes = isHeap(root.left, ++currentLength);
      Boolean rightRes = isHeap(root.right, ++currentLength);
      if (leftRes == Boolean.FALSE || rightRes == Boolean.FALSE) {
        return Boolean.FALSE;
      } else {
        return Boolean.TRUE;
      }
    }
    return false;
  }
}
