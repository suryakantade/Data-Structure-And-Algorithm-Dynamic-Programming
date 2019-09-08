package com.datastructure.Binarytree;

public class RootNodeForTwoNode {

  TreeNode root = null;

  public RootNodeForTwoNode(TreeNode node) {
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
    TreeNode rootNode = findRoot(bst.root,4,2);
    System.out.println(null != rootNode?rootNode.val:null);
  }
  public static TreeNode findRoot(TreeNode root, int element1, int element2){
    if(null == root){
      return null;
    }
    TreeNode eleLeftNode = findRoot(root.left,element1,element2);
    TreeNode eleRightNode = findRoot(root.right, element1,element2);
    if(null != eleLeftNode && null != eleRightNode){
      return root;
    }
    if((root.val==element1||root.val==element2 )&&(eleLeftNode!=null||eleRightNode!=null)){
      return root;
    }
    if(null != eleLeftNode){
      eleLeftNode = findRoot(root.left,element1,element2);
      if(null != eleLeftNode){
        return eleLeftNode;
      }
    }
    if(null != eleRightNode){
       eleRightNode = findRoot(root.right,element1,element2);
       if(null != eleRightNode){
         return eleRightNode;
       }
    }
    if(root.val==element1||root.val==element2 ){
      return root;
    }
    return null;
  }
}
