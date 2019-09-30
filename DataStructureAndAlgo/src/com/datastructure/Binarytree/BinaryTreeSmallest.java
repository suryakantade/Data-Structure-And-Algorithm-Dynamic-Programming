package com.datastructure.Binarytree;

public class BinaryTreeSmallest {

  TreeNode root;

  public BinaryTreeSmallest(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    BinaryTreeSmallest binaryTree = new BinaryTreeSmallest(new TreeNode(117));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));
    System.out.println(smallestNo(binaryTree.root, Integer.MAX_VALUE));
  }

  public static int smallestNo(TreeNode root, Integer min) {
    if (root == null) {
      return min;
    }
    if (root.val < min) {
      min = root.val;
    }
    return Math.min(Math.min(smallestNo(root.left, min), smallestNo(root.right, min)), min);
  }
}
