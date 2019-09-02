package com.datastructure.Binarytree;

import com.sun.tools.javac.util.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
  TreeNode root;

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree(new TreeNode(1));
    binaryTree.root.setLeft(new TreeNode(2));
    binaryTree.root.setRight(new TreeNode(3));
    binaryTree.root.getLeft().setLeft(new TreeNode(4));
    binaryTree.root.getLeft().setRight(new TreeNode(5));

    binaryTree.root.getRight().setLeft(new TreeNode(6));
    binaryTree.root.getRight().setRight(new TreeNode(7));
    //System.out.println(binaryTree.root);
    //binaryTree.levelOrder(binaryTree.root);

    binaryTree.insertInLevelOrder(binaryTree.root, new TreeNode(8));
  }

  public void inOrder(TreeNode root) {

  }

  public void levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.println(node.val);
      if (null != node.getLeft()) {
        queue.add(node.getLeft());
      }
      if (null != node.getRight()) {
        queue.add(node.getRight());
      }
    }
  }

  public void insertInLevelOrder(TreeNode root, TreeNode node) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      root = node;
    } else {
      queue.add(root);
      while (!queue.isEmpty()) {
        TreeNode tmpNode = queue.poll();
        if (null != tmpNode.getLeft()) {
          queue.add(tmpNode.getLeft());
        } else {
          tmpNode.setLeft(node);
          break;
        }
        if (null != tmpNode.getRight()) {
          queue.add(tmpNode.getRight());
        } else {
          tmpNode.setRight(node);
          break;
        }
      }
    }
    levelOrder(root);
  }

  public void deleteNode(TreeNode root, TreeNode nodeToBeDeleted) {
    //find node to be deleted
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    Boolean isFound = Boolean.FALSE;
    TreeNode tmp = null;
    while (!queue.isEmpty()) {
      //.equals is not accurate as there can be same 2 objects with same value
      tmp = queue.poll();
      if (tmp == nodeToBeDeleted || root.equals(nodeToBeDeleted)) {
        isFound = Boolean.TRUE;
        break;
      }
      if (null != tmp.getLeft()) {
        queue.add(tmp.getLeft());
      }
      if (null != tmp.getRight()) {
        queue.add(tmp.getRight());
      }
    }
    Assert.check(!isFound, "Node is not found to be deleted");
    TreeNode rightMostNode = findRightMost(root);
    if(null != rightMostNode){
        tmp.val = rightMostNode.val;
        rightMostNode = null;
    }
  }
  public TreeNode findRightMost(TreeNode root){
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root.right);
    TreeNode rightMostNode = null;
    while(!queue.isEmpty()){
      TreeNode tmpNode = queue.poll();
      if(tmpNode.getLeft() ==null && tmpNode.getRight()==null){
        rightMostNode = tmpNode;
        tmpNode = null;
        break;
      }
      if(null != tmpNode.getLeft()){
        queue.add(tmpNode.getLeft());
      }
      if (null !=tmpNode.getRight()){
        queue.add(tmpNode.getRight());
      }
    }
    return rightMostNode;
  }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  @Override
  public String toString() {
    return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
  }
}