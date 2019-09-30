package com.datastructure.Binarytree;

public class SecondLargestInBTree {
  TreeNode root;

  //https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/
  public SecondLargestInBTree(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    SecondLargestInBTree binaryTree = new SecondLargestInBTree(new TreeNode(117));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(1));
    System.out.println(findSecondHighest(binaryTree.root,0,0));
  }

  public static int findSecondHighest(TreeNode node, Integer max , Integer secondMax){
    if(null == node){
      return  secondMax;
    }
    if(node.val>max){
      int tmp = max;
      max = node.val;
      secondMax = tmp;
    }else if(node.val>secondMax){
      secondMax=node.val;
    }
    int leftSecondMax = findSecondHighest(node.left,max,secondMax);
    int rightSecondMax = findSecondHighest(node.right,max,secondMax);
    return Integer.max(Integer.max(leftSecondMax,rightSecondMax),secondMax);
  }
}
