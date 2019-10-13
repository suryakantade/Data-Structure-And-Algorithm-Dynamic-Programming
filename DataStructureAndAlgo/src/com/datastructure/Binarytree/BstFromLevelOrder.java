package com.datastructure.Binarytree;

public class BstFromLevelOrder {

  public static void main(String[] args) {
    int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
    TreeNode root = null;
    for(int i=0;i<arr.length;i++){
      root = addNode(root, arr[i]);
    }
    BinaryTree binaryTree = new BinaryTree(root);
    binaryTree.levelOrder(root);
  }
  public static TreeNode addNode(TreeNode node, int val){
    if(node == null){
      return node = new TreeNode(val);
    }
    if(node.val>= val){
      node.left = addNode(node.left, val);
    }else{
      node.right = addNode(node.right, val);
    }
    return node;
  }
}
