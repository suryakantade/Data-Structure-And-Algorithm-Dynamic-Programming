package com.datastructure.LinkedListDouble;


public class ReArrangeListOddEven {

  //1 2 3 4 5 6 7 8 9
  //1 3 5 7 9 2 4 6 8
  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.createList(12);
    linkedListDouble.traverse(reArrange(linkedListDouble.source));

  }
  public static Node<Integer> reArrange(Node<Integer> node){
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    if(linkedListDouble.size(node)<=2){
      return node;
    }
    Node<Integer> oddNodes= null;
    Node<Integer> evenNodes = null;
    Node<Integer> oddStart = null;
    Node<Integer> evenNodeStart= null;
    int count = 1;
    while(node.hasNext()){
      if(count == 1){
        oddNodes = node;
        oddStart = oddNodes;
      }else if(count == 2){
        evenNodes = node;
        evenNodeStart = evenNodes;
      }else if(count %2==1){
        oddNodes.setNext(node);
        oddNodes = oddNodes.next;
      }else if(count % 2==0){
        evenNodes.setNext(node);
        evenNodes= evenNodes.next;
      }
      node=node.next;
      count++;
    }
    oddNodes.setNext(evenNodeStart);
    return oddStart;
  }
}
