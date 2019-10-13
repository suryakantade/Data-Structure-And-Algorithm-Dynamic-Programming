package com.datastructure.LinkedListDouble;

public class BInaryLinkedListToDecimal {
  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.createBinaryList(2);
    linkedListDouble.traverse(linkedListDouble.source);
    System.out.println();
    System.out.println("decimal : "+findDecimal(linkedListDouble.source));
  }

  public static int findDecimal(Node<Integer> root){
    int res = 0;
    while (root!=null){
      res=(res<<1)+root.value;
      root = root.next;
    }
    return res;
  }
}
