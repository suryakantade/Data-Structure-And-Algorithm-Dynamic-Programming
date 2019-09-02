package com.datastructure.LinkedListDouble;

public class Node<T> {
  T value;
  Node next;
  Node Prev;

  public boolean hasNext() {
    if (this.getNext() != null) {
      return true;
    } else {
      return false;
    }
  }

  public Node(T value, Node next, Node prev) {
    super();
    this.value = value;
    this.next = next;
    Prev = prev;
  }

  /*@Override
  public String toString() {
    return "Node [value=" + value + ", next=" + next + ", Prev=" + Prev + "]";
  }*/

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return Prev;
  }

  public void setPrev(Node prev) {
    Prev = prev;
  }

}