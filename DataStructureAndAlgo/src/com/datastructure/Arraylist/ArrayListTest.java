package com.datastructure.Arraylist;

public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList<String> list= new ArrayList<>(20);
    list.add("surya");
    list.remove(0);
    System.out.println(list.get(0));
  }
}
