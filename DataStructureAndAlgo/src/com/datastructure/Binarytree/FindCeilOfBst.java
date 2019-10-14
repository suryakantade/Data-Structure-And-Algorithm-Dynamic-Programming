package com.datastructure.Binarytree;

public class FindCeilOfBst {

  TreeNode root;

  public FindCeilOfBst(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    FindCeilOfBst binaryTree = new FindCeilOfBst(new TreeNode(10));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));

    for (int i =0;i<15;i++){
      System.out.println(i+"   -->  "+findceil(binaryTree.root, i));
    }

  }

  public static int findceil(TreeNode root, int ceilOf){
    if(root == null){
      return -1;
    }
    if(root.val == ceilOf){
      return root.val;
    }
    if(root.val<ceilOf){
      return findceil(root.right, ceilOf);
    }
    int ceil = findceil(root.left, ceilOf);
    return ceil > ceilOf ? ceil : root.val;
  }
}
