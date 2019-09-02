package com.datastructure.Arraylist;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E>{


  Object[] arr;

  int size;
  float thresHold = 0.75f;
  int capacity = 12;
  public ArrayList(int capacity) {
    this.capacity = capacity;
    arr = new Object[this.capacity];
  }

  public ArrayList(int capacity, float thresHold) {
    this.capacity = capacity;
    arr = new Object[this.capacity];
    this.thresHold = thresHold;
  }

  public E get(int index){
    Assert.check(size>index || index>=0,"Array index out of bound");
    return (E)arr[index];
  }

  public void add(E e){
    checkNdAddSize();
    arr[size++] = e;
  }
  public void add(Iterable<E> iterable){
    Iterator iterator = iterable.iterator();
    while (iterator.hasNext()){
      add((E)iterator.next());
    }
  }
  public void remove(int index){
    Assert.check(size>index || index>=0,"Array index out of bound");
    for (int i = index; i < size; i++) {
      arr[i]=arr[i+1];
    }
    size--;

  }
  public void checkNdAddSize(){
    if(thresHold*this.capacity<=size){
      Arrays.copyOf(arr, capacity<<1);
    }
  }
  public void checkNdDecrease(){
    if((capacity/2)*thresHold>=size){
      Arrays.copyOf(arr, capacity/2);
    }
  }

}
