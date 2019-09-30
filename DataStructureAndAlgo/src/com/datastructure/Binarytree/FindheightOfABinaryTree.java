package com.datastructure.Binarytree;

public class FindheightOfABinaryTree {
  TreeNode root;

  public FindheightOfABinaryTree(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    FindheightOfABinaryTree binaryTree = new FindheightOfABinaryTree(new TreeNode(117));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));
    binaryTree.root.getRight().getRight().setRight(new TreeNode(13));
    System.out.println(findHeightOfABinaryTree(binaryTree.root, 0));
  }

  public static int findHeightOfABinaryTree(TreeNode node, int height) {
    if (node == null) {
      return height;
    }
    return Math.max(findHeightOfABinaryTree(node.left, height + 1),
        findHeightOfABinaryTree(node.right, height + 1));
  }
}
