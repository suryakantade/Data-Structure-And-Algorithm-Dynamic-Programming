package com.datastructure.Binarytree;

//https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
public class LongestConsicutiveSequenceBinaryTree {

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new TreeNode(1));
    binaryTree.root.setLeft(new TreeNode(9));
    binaryTree.root.setRight(new TreeNode(4));
    binaryTree.root.getLeft().setLeft(new TreeNode(3));
    binaryTree.root.getLeft().setRight(new TreeNode(5));

    binaryTree.root.getRight().setLeft(new TreeNode(6));
    binaryTree.root.getRight().setRight(new TreeNode(7));
    System.out
        .println(LongestConsicutiveSequenceBinaryTree.findLongesConsSeqBtree(binaryTree.root, 0));
  }

  public static int findLongesConsSeqBtree(TreeNode root, int longest) {
    int longestSeqLeft = 0;
    int longestSeqRight = 0;
    if(root.left == null && root.right==null){
      return longest+1;
    }
    if (null != root.left) {
      if (root.val == root.left.val - 1) {
        longestSeqLeft = findLongesConsSeqBtree(root.left, longest+1);
      } else {
        longestSeqLeft = findLongesConsSeqBtree(root.left,0);
      }
    }
    if(longestSeqLeft>longest+1){
      longest = longestSeqLeft;
    }else{
      longest++;
    }
    if (null != root.right) {
      if (root.right.val == root.right.val - 1) {
        longestSeqRight = findLongesConsSeqBtree(root.right,longest+1);
      } else {
        longestSeqRight = findLongesConsSeqBtree(root.left,0);
      }
    }
    if(longestSeqRight>longest){
      longest = longestSeqRight;
    }
    return longest;
  }
}
