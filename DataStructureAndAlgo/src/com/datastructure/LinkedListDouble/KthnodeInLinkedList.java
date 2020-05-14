package com.datastructure.LinkedListDouble;

public class KthnodeInLinkedList {
  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.createList(10);
    linkedListDouble.traverse(linkedListDouble.source);
    int k = 3;
    Node kthNode = getKth(linkedListDouble, k);
    System.out.println("\nkth element from end: "+kthNode.value);
  }

  public static Node getKth(LinkedListDouble linkedListDouble, int k) {

    Node ptr = null;
    Node tmp = linkedListDouble.source;
    int count = 0;
    while (tmp.next != null) {
      count++;
      if (count >= k) {
        if (ptr == null) {
          ptr = linkedListDouble.source;
        }else{
          ptr = ptr.next;
        }
      }
      tmp = tmp.next;
    }
    return ptr;
  }
}
