package com.datastructure.Binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
public class MergeTwoBsts {
  TreeNode root;

  public MergeTwoBsts(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    MergeTwoBsts binaryTree = new MergeTwoBsts(new TreeNode(117));

    binaryTree.root.setLeft(new TreeNode(8));
    binaryTree.root.setRight(new TreeNode(12));

    binaryTree.root.getLeft().setLeft(new TreeNode(7));
    binaryTree.root.getLeft().setRight(new TreeNode(9));

    binaryTree.root.getRight().setLeft(new TreeNode(11));
    binaryTree.root.getRight().setRight(new TreeNode(13));

    MergeTwoBsts binaryTree1 = new MergeTwoBsts(new TreeNode(11));
    binaryTree1.root.setLeft(new TreeNode(8));
    binaryTree1.root.setRight(new TreeNode(12));
    binaryTree1.root.getLeft().setLeft(new TreeNode(7));
    binaryTree1.root.getLeft().setRight(new TreeNode(9));
    binaryTree1.root.getRight().setLeft(new TreeNode(11));
    binaryTree1.root.getRight().setRight(new TreeNode(13));

    System.out.println(mergeTwoB(binaryTree.root, binaryTree1.root));

  }

  public static List<Integer> mergeTwoB(TreeNode firstNode, TreeNode secondNode) {
    Stack<TreeNode> firstStack = new Stack<>();
    Stack<TreeNode> secondStack = new Stack<>();
    while (null != firstNode && secondNode != null) {
      if (firstNode != null) {
        firstStack.push(firstNode);
        firstNode = firstNode.left;
      }
      if (secondNode != null) {
        secondStack.push(secondNode);
        secondNode = secondNode.left;
      }
    }
    List<Integer> resList = new ArrayList<>();
    while (!firstStack.isEmpty() && !secondStack.isEmpty()) {
      if (firstStack.isEmpty()) {
        TreeNode tmp = secondStack.pop();
        resList.add(tmp.val);
        if (null != tmp.right) {
          secondStack.push(tmp.right);
        }
      } else if (secondStack.isEmpty()) {
        TreeNode tmp = firstStack.pop();
        resList.add(tmp.val);
        if(tmp.right != null){
          firstStack.push(tmp.right);
        }
      } else {
        if (firstStack.peek().val >= secondStack.peek().val) {
          TreeNode tmp = secondStack.pop();
          resList.add(tmp.val);
          if (null != tmp.right) {
            secondStack.push(tmp.right);
          }
        } else {
          TreeNode tmp = firstStack.pop();
          resList.add(tmp.val);
          if(tmp.right != null){
            firstStack.push(tmp.right);
          }
        }
      }
    } return resList;
  }


}
