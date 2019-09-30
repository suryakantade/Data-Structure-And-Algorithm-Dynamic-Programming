package com.datastructure.Binarytree;

public class IsBst {

  TreeNode root;

  public IsBst(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    IsBst binaryTree = new IsBst(new TreeNode(117));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));

    System.out.println(isBst(binaryTree.root));
  }

  public static boolean isBst(TreeNode root){
    if(root== null){
      return true;
    }
    if(isValidLeft(root, root.left) && isValidRight(root, root.right)){
      return isBst(root.left) && isBst(root.right);
    }
    return false;
  }
  public static boolean isValidLeft(TreeNode currentNode, TreeNode leftNode){
    if(null == leftNode || currentNode.val>leftNode.val){
      return true;
    }
    return false;
  }

  public static boolean isValidRight(TreeNode currentNode, TreeNode rightNode){
    if(null == rightNode || currentNode.val<rightNode.val){
      return true;
    }
    return false;
  }
}
