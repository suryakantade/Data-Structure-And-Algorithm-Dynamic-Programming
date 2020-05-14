package com.datastructure.LinkedListDouble;

import java.util.List;

public class MergeSortOnLinkedLIst {

  public static void main(String[] args) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.createList(10);
    linkedListDouble.traverse(linkedListDouble.source);
    System.out.println("\nafter merge sort \n");
    Node sortedList = sortLinkedList(linkedListDouble, linkedListDouble.source);
    linkedListDouble.traverse(sortedList);
  }

  public static Node sortLinkedList(LinkedListDouble linkedListDouble, Node node) {
    int size = linkedListDouble.size(node);
    if (null == node || size <= 1) {
      return node;
    }
    List<Node> dividedList = linkedListDouble.divideLinkedList(node, size);
    Node firstHalf = dividedList.get(0);
    Node secondHalf = dividedList.get(1);
    firstHalf = sortLinkedList(linkedListDouble, firstHalf);
    secondHalf = sortLinkedList(linkedListDouble, secondHalf);
    return merge(firstHalf, secondHalf, linkedListDouble);
  }

  public static Node merge(Node<Integer> firstHalf, Node<Integer> secondHalf,
      LinkedListDouble linkedListDouble) {
    Node mergedNode = null;
    while (linkedListDouble.size(firstHalf) >= 1 || linkedListDouble.size(secondHalf) >= 1) {
      if (null == firstHalf) {
        mergedNode = linkedListDouble.addNodeInEnd(mergedNode, secondHalf);
        secondHalf = secondHalf.next;
      } else if (null == secondHalf) {
        mergedNode = linkedListDouble.addNodeInEnd(mergedNode, firstHalf);
        firstHalf = firstHalf.next;
      } else {
        if (firstHalf.value > secondHalf.value) {
          mergedNode = linkedListDouble.addNodeInEnd(mergedNode, secondHalf);
          secondHalf = secondHalf.next;
        } else {
          mergedNode = linkedListDouble.addNodeInEnd(mergedNode, firstHalf);
          firstHalf = firstHalf.next;
        }
      }
    }
    return mergedNode;

  }
}
