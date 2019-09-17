package com.datastructure.Binarytree;


public class LargestBSTInBtree {
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
    System.out
        .println(findLargest(binaryTree.root));
  }

  public static int findLargest(TreeNode root) {
    if(root == null ){
      return 0;
    }
    int lCount = findLargest(root.left);
    int rCount = findLargest(root.right);
    if((null == root.left|| root.left.val<root.val) &&
        (null == root.right|| root.right.val>root.val)){
      if(lCount == 0 && root.left != null){
        return rCount;
      }
      if(rCount == 0 && root.right != null){
        return lCount;
      }
      return 1+lCount+rCount;
    }else{
      return 0;//Math.max(lCount,rCount);
    }
  }
}
