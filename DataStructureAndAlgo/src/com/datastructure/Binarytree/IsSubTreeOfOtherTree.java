package com.datastructure.Binarytree;

public class IsSubTreeOfOtherTree {

  TreeNode root;

  public IsSubTreeOfOtherTree(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    IsSubTreeOfOtherTree binaryTree = new IsSubTreeOfOtherTree(new TreeNode(117));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));

    TreeNode treeNode = new TreeNode(8);
    treeNode.setLeft(new TreeNode(7));
    treeNode.setRight(new TreeNode(9));


    System.out.println(isSubTree(binaryTree.root, treeNode));
  }

  public static Boolean isSubTree(TreeNode parent, TreeNode childNode){
    if(true == isTwoTreeEqual(parent, childNode)){
      return true;
    }
    if(true == isTwoTreeEqual(parent.left, childNode)){
      return true;
    }
    if(true == isTwoTreeEqual(parent.right, childNode)){
      return true;
    }
    return false;
  }

  public static Boolean isTwoTreeEqual(TreeNode parent, TreeNode childNode){
    if(parent == childNode){
      return true;
    }
    if(null != parent  && null != childNode){
      if (parent.val == childNode.val && isTwoTreeEqual(parent.left, childNode.left)
          && isTwoTreeEqual(parent.right, childNode.right)) {
        return true;
      }
      return false;
    }
    return false;
  }
}
