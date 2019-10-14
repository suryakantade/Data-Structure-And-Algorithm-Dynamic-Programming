package com.datastructure.LinkedListDouble;

public class AddOne {
  Node<Integer> root = null;

  public AddOne(Integer element) {
    this.root = new Node<>(element, null, null);
  }

  public static void main(String[] args) {
    AddOne addOne = new AddOne(1);
    addOne.root.setNext(new Node(9, null, null));
    addOne.root.next.setNext(new Node(9, null, null));
    addOne.root.next.next.setNext(new Node(9, null, null));

    //add 1
    addOne(addOne.root,1);
    LinkedListDouble linkedListDouble = new LinkedListDouble();
    linkedListDouble.traverse(addOne.root);

  }

  public static int addOne(Node<Integer> root, int n) {
    if (root.next == null) {
      if (root.value + n > 9) {
        int sum = root.value + n;
        root.value = (sum) % 10;
        return (sum) / 10;
      } else {
        root.value += n;
        return 0;
      }
    } else {
      int res = addOne(root.next, n);
      int sum = res + root.value;
      if (sum > 9) {
        root.value = (sum) % 10;
        return (sum) / 10;
      } else {
        root.value += res;
        return 0;
      }
    }
  }
}
