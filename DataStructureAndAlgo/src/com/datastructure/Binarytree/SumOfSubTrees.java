package com.datastructure.Binarytree;

//https://www.geeksforgeeks.org/change-a-binary-tree-so-that-every-node-stores-sum-of-all-nodes-in-left-subtree/
public class SumOfSubTrees {
  TreeNode root;

  public SumOfSubTrees(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    SumOfSubTrees binaryTree = new SumOfSubTrees(new TreeNode(1));
    binaryTree.root.setLeft(new TreeNode(2));
    binaryTree.root.setRight(new TreeNode(3));
    binaryTree.root.getLeft().setLeft(new TreeNode(4));
    binaryTree.root.getLeft().setRight(new TreeNode(5));

    binaryTree.root.getRight().setLeft(new TreeNode(6));
    binaryTree.root.getRight().setRight(new TreeNode(7));
    binaryTree.findSumOfIndiviNode(binaryTree.root);
    BinarySearchTree bst = new BinarySearchTree(binaryTree.root);
    bst.preOrder(bst.root);
    System.out.println();
    bst.inOrderTraversal(bst.root);
    System.out.println();
    bst.postOrder(bst.root);

  }

  public int findSumOfIndiviNode(TreeNode root) {
    if (null == root) {
      return 0;
    }
    int sum = root.val;
    int leftSum = findSumOfIndiviNode(root.left);
    int rightSum = findSumOfIndiviNode(root.right);
    sum = sum + leftSum + rightSum;
    root.val = sum;
    return sum;
  }
}
