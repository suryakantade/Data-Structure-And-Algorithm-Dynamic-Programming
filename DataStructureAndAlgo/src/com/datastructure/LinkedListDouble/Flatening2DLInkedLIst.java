package com.datastructure.LinkedListDouble;

public class Flatening2DLInkedLIst {

  /*
  1   5    10
  2   6    11
  3   7    12
  4   8    13
      9    14*/

  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    Node<Integer> node = new Node<>(1, new Node(5, new Node(10, null,
        new Node(11, new Node(12, new Node(13, new Node(14, null, null), null), null), null)),
        new Node(6, new Node(7, new Node(8, new Node(9, null, null), null), null), null)),
        new Node(2, new Node(3, new Node(4, null, null), null), null));
    linkedListDouble.traverse(node);
    flatten(node);
    linkedListDouble.traverse(node);
  }

  public static void flatten(Node<Integer> node){
    Node<Integer> tmp = node;
    Node<Integer> nextTmp = null;
    while(tmp != null){
     if(tmp.getPrev() != null) {
       nextTmp = tmp.next;
       tmp.setNext(tmp.getPrev());
       tmp.setPrev(null);
     }
     if(tmp.next == null){
       tmp.next = nextTmp;
     }
     tmp = tmp.next;
    }
  }
}
