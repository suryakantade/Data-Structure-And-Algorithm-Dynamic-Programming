package com.datastructure.Binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
  TreeNode root = null;

  public BinarySearchTree(TreeNode node) {
    this.root = node;
  }

  public static void main(String[] args) {
    //new HashMap<>()
    BinarySearchTree bst = new BinarySearchTree(new TreeNode(5));
    bst.add(bst.root, 3);
    bst.add(bst.root, 4);
    bst.add(bst.root, 1);
    bst.add(bst.root, 2);
    bst.add(bst.root, 7);
    bst.add(bst.root, 6);
    bst.add(bst.root, 8);
    bst.add(bst.root, 9);
    System.out.println("Inorder: ");
    bst.inOrderTraversal(bst.root);
    System.out.println("\nInorder with stack: ");
    bst.inOrderTraversalWithStack(bst.root);
    System.out.println("\nPreorder: ");
    bst.preOrder(bst.root);
    System.out.println("\nPostorder: ");
    bst.postOrder(bst.root);
  }

  //adding element in bst
  public TreeNode add(TreeNode root, int element) {
    if (root == null) {
      return root = new TreeNode(element);
    } else if (root.val > element) {
      root.setLeft(add(root.left, element));
      return root;
    } else {
      root.setRight(add(root.right, element));
      return root;
    }
  }

  public void inOrderTraversal(TreeNode root) {
    if (null != root.getLeft()) {
      inOrderTraversal(root.getLeft());
    }
    System.out.print(" " + root.val);
    if (null != root.getRight()) {
      inOrderTraversal(root.getRight());
    }
  }

  public void preOrder(TreeNode root) {
    System.out.print(" " + root.val);
    if (null != root.getLeft()) {
      preOrder(root.getLeft());
    }
    if (null != root.getRight()) {
      preOrder(root.getRight());
    }
  }

  public void postOrder(TreeNode root) {
    if (null != root.getLeft()) {
      postOrder(root.getLeft());
    }
    if (null != root.getRight()) {
      postOrder(root.getRight());
    }
    System.out.print(" " + root.val);
  }

  public int size(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return size(root.getLeft()) + 1 + size(root.getRight());
    }
  }

  public int findMax(TreeNode root) {
    if (null != root.getRight()) {
      return findMax(root.getRight());
    } else {
      return root.val;
    }
  }

  public int findMin(TreeNode root) {
    if (null != root.getLeft()) {
      return findMin(root.getLeft());
    } else {
      return root.val;
    }
  }

  public void printLeftRightView(TreeNode root, Boolean isLeft) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (isLeft && null != root.getLeft()) {
      queue.add(root.getLeft());
    } else if (!isLeft && null != root.getRight()) {
      queue.add(root.getRight());
    }
    while (!queue.isEmpty()) {
      TreeNode tmpNode = queue.poll();
      System.out.println(tmpNode.val);
      if (null != tmpNode.getLeft()) {
        queue.add(tmpNode.getLeft());
      }
      if (null != tmpNode.getRight()) {
        queue.add(tmpNode.getRight());
      }
    }
  }
  //https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
  public void inOrderTraversalWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    pushAllLeftNodes(stack, root);
    while (!stack.isEmpty()) {
      TreeNode tmp = stack.pop();
      System.out.print(" "+tmp.val);
      if (null != tmp.getRight()) {
        pushAllLeftNodes(stack, tmp.getRight());
      }
    }
  }

  public void pushAllLeftNodes(Stack<TreeNode> stack, TreeNode root) {
    if (root != null) {
      stack.push(root);
    }
    while (root.getLeft() != null) {
      stack.push(root.getLeft());
      root = root.getLeft();
    }
  }
}
