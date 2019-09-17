package com.datastructure.Binarytree;

public class RemoveLeafNOdes {
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new TreeNode(50));
    binaryTree.root.setLeft(new TreeNode(30));
    binaryTree.root.setRight(new TreeNode(60));
    binaryTree.root.getLeft().setLeft(new TreeNode(5));
    binaryTree.root.getLeft().setRight(new TreeNode(20));

    binaryTree.root.getRight().setLeft(new TreeNode(45));
    binaryTree.root.getRight().setRight(new TreeNode(70));
    binaryTree.root.getRight().getRight().setLeft(new TreeNode(65));
    binaryTree.root.getRight().getRight().setRight(new TreeNode(80));
    removeLeafNodes(binaryTree.root);
    binaryTree.preOrder(binaryTree.root);
  }
  public static TreeNode removeLeafNodes(TreeNode root){
    if(null == root){
      return null;
    }
    if(root != null && root.left == null && root.right == null){

      return root = null;

    }
    root.setLeft(removeLeafNodes(root.left));
    root.setRight(removeLeafNodes(root.right));
    return root;
  }
}
