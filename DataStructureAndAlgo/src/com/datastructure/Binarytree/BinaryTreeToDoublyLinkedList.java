package com.datastructure.Binarytree;

import com.datastructure.LinkedListDouble.LinkedListDouble;
import com.datastructure.LinkedListDouble.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeToDoublyLinkedList {
  TreeNode root;
  Stack<Node> stack = new Stack<>();

  Queue<Node> queue = new LinkedList();
  public BinaryTreeToDoublyLinkedList(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    BinaryTreeToDoublyLinkedList binaryTree = new BinaryTreeToDoublyLinkedList(new TreeNode(1));
    binaryTree.root.setLeft(new TreeNode(2));
    binaryTree.root.setRight(new TreeNode(3));
    binaryTree.root.getLeft().setLeft(new TreeNode(4));
    binaryTree.root.getLeft().setRight(new TreeNode(5));

    binaryTree.root.getRight().setLeft(new TreeNode(6));
    binaryTree.root.getRight().setRight(new TreeNode(7));
    /*Node root = binaryTree.getLInkedLIst(binaryTree.root);
    LinkedListDouble lsd = new LinkedListDouble();
    lsd.traverse(root);*/

    //soln1
    binaryTree.GetLinkedListWithQueue(binaryTree.root);
    Node root = binaryTree.traveQueueAndGenerateLinkedList();
    LinkedListDouble lsd = new LinkedListDouble();
    lsd.traverse(root);
  }
  /*
              2
             /\
            1  3
   */

  public void GetLinkedListWithQueue(TreeNode treeNode) {
    if(null == treeNode) {
      return;
    }
    GetLinkedListWithQueue(treeNode.getLeft());
    queue.add(new Node(treeNode.val,null,null));
    GetLinkedListWithQueue(treeNode.getRight());
  }
  public Node traveQueueAndGenerateLinkedList(){
    Node rootNode = queue.poll();
    Node prev = rootNode;
    while(!this.queue.isEmpty()){
      Node currentNode = queue.poll();
      prev.setNext(currentNode);
      currentNode.setPrev(prev);

      prev = currentNode;
    }
    return rootNode;
  }


  public Node getLInkedLIst(TreeNode treeNode) {

    Node left = null;
    Node right = null;
    if (null != treeNode.left) {
      left = getLInkedLIst(treeNode.left);
    }

    Node currentNode = new Node(treeNode.val, left, null);
    if (null != left) {
      left.setPrev(currentNode);
      //stack.push(left);
    }
    if (null != treeNode.right) {
      right = getLInkedLIst(treeNode.right);
    }
    if (null != right) {
      right.setNext(currentNode);
      currentNode.setPrev(right);
      //stack.push(currentNode);
    }
    return right != null ? right : currentNode;
  }

}