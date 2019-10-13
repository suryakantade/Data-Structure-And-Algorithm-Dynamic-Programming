package com.datastructure.Binarytree;


import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
public class FindCommonElements {
  public static Set<Integer> set = new HashSet<>();
  public static Set<Integer> setResp = new HashSet<>();
  TreeNode root;

  public FindCommonElements(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    FindCommonElements binaryTree = new FindCommonElements(new TreeNode(117));
    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));
    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));
    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));

    FindCommonElements binaryTree1 = new FindCommonElements(new TreeNode(11));
    binaryTree1.root.setLeft(new TreeNode(8));
    binaryTree1.root.setRight(new TreeNode(12));
    binaryTree1.root.getLeft().setLeft(new TreeNode(7));
    binaryTree1.root.getLeft().setRight(new TreeNode(9));
    binaryTree1.root.getRight().setLeft(new TreeNode(11));
    binaryTree1.root.getRight().setRight(new TreeNode(13));


    traverse(binaryTree.root);
    traverseAndFindMatch(binaryTree1.root);
    System.out.println(setResp);
  }

  public static void traverse(TreeNode treeNode) {
    if (null == treeNode) {
      return;
    }
    set.add(treeNode.val);
    traverse(treeNode.left);
    traverse(treeNode.right);
  }

  public static void traverseAndFindMatch(TreeNode treeNode) {
    if (null == treeNode) {
      return;
    }
    if (set.contains(treeNode.val)) {
      setResp.add(treeNode.val);
    }
    traverseAndFindMatch(treeNode.left);
    traverseAndFindMatch(treeNode.right);
  }
}
