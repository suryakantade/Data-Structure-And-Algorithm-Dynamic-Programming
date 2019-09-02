package com.datastructure.Binarytree;

//https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror
// -tree/
public class MirrorTree {
  TreeNode root;

  public MirrorTree(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    MirrorTree binaryTree = new MirrorTree(new TreeNode(1));
    binaryTree.root.setLeft(new TreeNode(2));
    binaryTree.root.setRight(new TreeNode(3));
    binaryTree.root.getLeft().setLeft(new TreeNode(4));
    binaryTree.root.getLeft().setRight(new TreeNode(5));
    binaryTree.root.getRight().setLeft(new TreeNode(6));
    binaryTree.root.getRight().setRight(new TreeNode(7));

    BinarySearchTree bst = new BinarySearchTree(binaryTree.root);
    bst.inOrderTraversal(bst.root);

    binaryTree.convertTreeToMirrorTree(binaryTree.root);


    System.out.println("\nInorder before reflection: ");
    bst.inOrderTraversal(bst.root);
    System.out.println("\nPre Order");
    bst.preOrder(bst.root);
    System.out.println("\nPost Order: ");
    bst.postOrder(bst.root);

  }
  public void convertTreeToMirrorTree(TreeNode node){
    if(null == node){
      return;
    }
    TreeNode tmpNode= node.left;
    node.left=node.right;
    node.right = tmpNode;
    convertTreeToMirrorTree(node.left);
    convertTreeToMirrorTree(node.right);
  }
}
