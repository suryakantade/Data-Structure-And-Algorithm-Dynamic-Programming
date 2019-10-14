package com.datastructure.LinkedListDouble;

import java.util.LinkedList;

public class MergeTwoLinkedList {
  String s = "";
  public static void main(String[] args) {
    LinkedListDouble ls = new LinkedListDouble();
    ls.createList(12);
    LinkedListDouble ls1 = new LinkedListDouble();
    ls1.createList(12);
    LinkedListDouble linkedListDouble = mergeTwoList(ls,ls1);
    linkedListDouble.traverse(linkedListDouble.source);
  }

  public static LinkedListDouble mergeTwoList(LinkedListDouble firstList,
      LinkedListDouble secondList) {
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    Node<Integer> firstNode = firstList.source;
    Node<Integer> secondNode = secondList.source;

    while (firstNode.hasNext() || secondNode.hasNext()) {
      if (null != firstNode && secondNode != null && firstNode.getValue() <= secondNode
          .getValue()) {
        linkedListDouble.addNodeInEnd(firstNode.getValue());
        firstNode = firstNode.getNext();
      } else if (null != firstNode && secondNode != null && firstNode.getValue() > secondNode
          .getValue()) {
        linkedListDouble.addNodeInEnd(secondNode.getValue());
        secondNode = secondNode.getNext();
      } else if (null != firstNode && null == secondNode) {
        linkedListDouble.addNodeInEnd(firstNode.getValue());
        firstNode = firstNode.getNext();
      } else if (null == firstNode && null != secondNode) {
        linkedListDouble.addNodeInEnd(secondNode.getValue());
        secondNode = secondNode.getNext();
      } else if (null == firstNode && null == secondNode) {
        break;
      }
    }
    return linkedListDouble;
  }
}
