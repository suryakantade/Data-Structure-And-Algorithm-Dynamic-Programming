package com.dynamicProgramming;

import java.util.*;

//https://www.geeksforgeeks.org/ugly-numbers/
public class garbageNumber {
  Map<Integer, Integer> map = null;

  public static void main(String[] args) {

  }

  public int getNthUglyNumber(int n) {
    return this.map.get(n);
  }

  public void setUglyNumbers() {
    this.map.put(1, 1);
    int i2 = 1;
    int i3 = 1;
    int i5 = 1;
    for (int i = 2; i < 150; i++) {
      int min = Math.min(i2 * 2, Math.min(i3 * 3, i5 * 5));
      map.put(i, min);
      if (min % i2 == 0) {
        i2 += 1;
      }
      if (min % i3 == 0) {
        i3 += 1;
      }
      if (min % i5 == 0) {
        i5 += 1;
      }
    }
  }
}
