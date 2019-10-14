package com.datastructure.LinkedListDouble;

public class IsCircular {
  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.createList(10);
    makeCir(linkedListDouble.source);
    System.out.println(isCircular(linkedListDouble.source));
  }
  public static boolean isCircular(Node<Integer> root){
    Node<Integer> tmp = root;
    while (tmp != null && tmp.next!=root){
      tmp = tmp.next;
    }
    if(tmp == null){
      return false;
    }
    return true;
  }
  public static void makeCir(Node<Integer> start){
    Node<Integer> tmp = start;
    while(tmp.hasNext()){
      tmp =tmp.next;
    }
    tmp.setNext(start);
  }
}
