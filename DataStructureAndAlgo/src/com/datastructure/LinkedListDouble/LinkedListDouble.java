package com.datastructure.LinkedListDouble;

import java.util.HashMap;
import java.util.Map;

public class LinkedListDouble {

  Node source = null;

  public static void main(String[] args) {
    LinkedListDouble ls = new LinkedListDouble();
    ls.createList(10);
    Map<String, String> aaaa = new HashMap<String, String>();
    //ls.addFirst(11);
    ls.traverse(ls.source);
    // ls.reverse();
    // ls.reverseSinglyLinkedList();
    //int index = ls.search(ls.source, 4);
    //System.out.println("\nnode at index > " + index);
    Node nthNode = ls.getNthNode(ls.source, 2, 0);//returns null if out of range
    System.out.println("\n3rd element is " + nthNode.getValue());
    Node nthFromLast = ls.findNthNodeFromEnd(ls.source, 1);
    System.out.println("2nd element from end > " + nthFromLast.value);
    Node middleNode = ls.getMiddleNode(ls.source);
    System.out.println(middleNode.value);
  }

  public int search(Node node, Integer value) {
    if (node == null) {
      return -1;
    }
    if (node.getValue().equals(value)) {
      return 1;
    } else {
      int i = search(node.next, value);
      if (i == -1) {
        return -1;
      } else {
        return i + 1;
      }
    }

  }

  public Node getNthNode(Node node, int indexToFetch, int currentIndex) {
    if (indexToFetch == currentIndex) {
      return node;
    }
    if (null == node) {
      return null;
    } else {
      return getNthNode(node.next, indexToFetch, currentIndex + 1);
    }
  }

  public void createList(int n) {
    for (int i = 1; i < n; i++) {
      addNodeInEnd(i);
    }
  }

  public void createBinaryList(int n) {
    for (int i = 1; i < n; i++) {
      addNodeInEnd(i%2);
    }
  }

  public boolean  addNodeInEnd(Integer val) {

    // tmp = tmp==null ? new Node(val, null, null):tmp;
    if (this.source == null) {
      this.source = new Node(val, null, null);
      return true;
    } else {
      Node tmp = source;
      while (tmp.hasNext()) {
        tmp = tmp.getNext();
      }
      tmp.next = new Node(val, null, tmp);
      return true;
    }
  }

  public void traverse(Node node) {
    Node tmp = node;
    int count = 0;
    System.out.println();
    while (tmp != null) {
      if (count == 0) {
        System.out.print("linked list : > " + tmp.getValue());
      } else {
        System.out.print("--> " + tmp.getValue());
      }
      tmp = tmp.next;
      count++;
    }
  }

  public void reverse() {
    if (this.source == null) {
      return;
    }
    while (this.source.hasNext()) {
      Node temp = this.source;
      this.source = source.next;
      Node prev = temp.Prev;
      temp.Prev = temp.next;
      temp.next = prev;

    }
    Node prev = this.source.Prev;
    this.source.next = prev;
    this.source.Prev = null;
    traverse(this.source);
  }

  public void reverseSinglyLinkedList() {
    if (this.source == null) {
      return;
    }
    Node prev = null;
    Node current = null;
    while (this.source.hasNext()) {
      current = this.source;
      this.source = this.source.next;
      current.next = prev;
      prev = current;

    }
    this.source.next = current;
    traverse(this.source);
  }

  public void addFirst(Integer val) {
    Node node = new Node(val, this.source, null);
    source.Prev = node;
    source = node;
  }

  public int size(Node root) {
    int count = 0;
    Node tmp  = root;
    while(tmp.hasNext()){
      count++;
      tmp = tmp.next;
    }
    return count;
  }

  public Node findNthNodeFromEnd(Node node, int index) {
    Node temp = node;
    int count = 1;
    boolean flag = false;
    while (temp.next != null) {
      temp = temp.next;
      if (count == index) {
        flag = true;
      }
      if (flag) {
        node = node.next;
      }
      count++;
    }
    if (flag) {
      return node;
    } else {
      return null;
    }
  }

  public Node getMiddleNode(Node node) {
    Node propagateTwice = node;
    while (propagateTwice != null && propagateTwice.next != null) {
      node = node.next;
      propagateTwice = null != propagateTwice.next ? propagateTwice.next.next : propagateTwice.next;
    }
    return node;
  }
}


