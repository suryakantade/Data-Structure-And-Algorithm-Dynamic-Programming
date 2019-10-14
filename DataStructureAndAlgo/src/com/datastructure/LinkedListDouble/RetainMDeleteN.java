package com.datastructure.LinkedListDouble;

public class RetainMDeleteN {

  public static void main(String[] args) {
      LinkedListDouble linkedListDouble = new LinkedListDouble();
      linkedListDouble.createList(18);
      retainMRemoveN(linkedListDouble.source, 2,2);
      linkedListDouble.traverse(linkedListDouble.source);

  }
  //1 2  5 6 9 10 13 14
  public static void retainMRemoveN(Node<Integer> node, int m , int n){
    //Node<Integer> tmp = node;
    Node<Integer> lastRetainedNode = null;
    boolean retain = true;
    int count =0;
    while (node.next != null){
      count++;
      if (retain){
        if(count == m){
          lastRetainedNode = node;
          count = 0;
          retain = false;
        }

      }else{
        if(count == n+1){
          lastRetainedNode.setNext(node);
          count = 1;
          retain =true;
        }else {
          lastRetainedNode.setNext(null);
        }
      }
      node=node.next;
    }
  }
}
