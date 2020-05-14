package com.datastructure.LinkedListDouble;

public class RotateLinkedLIst {

  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.createList(10);
    linkedListDouble.traverse(linkedListDouble.source);
    int noOfRotation = 3;
    System.out.println("after rotation of " + noOfRotation+"\n");
    rotate(noOfRotation, linkedListDouble);
    linkedListDouble.traverse(linkedListDouble.source);
  }

  public static void rotate(int k, LinkedListDouble linkedListDouble) {
    int size = linkedListDouble.size(linkedListDouble.source);
    k = k % size;
    int count = 1;
    Node start = linkedListDouble.source;
    Node root = linkedListDouble.source;
    while (count <= (size - k)) {
      root = root.next;
      count++;
    }
    linkedListDouble.source = root.next;
    linkedListDouble.source.setPrev(null);
    root.next = null;
    root = linkedListDouble.source;
    while (root.hasNext()) {
      root = root.next;
    }
    root.next = start;
    start.setPrev(root);

  }
}
