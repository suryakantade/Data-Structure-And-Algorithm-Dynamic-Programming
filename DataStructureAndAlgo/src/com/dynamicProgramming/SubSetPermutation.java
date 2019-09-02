package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetPermutation {
  private static int subSetSize;

  public static void main(String[] args) {
    subSetSize = 4;
    findAllSubset(Arrays.asList(10, 20, 30, 40, 50), "");

  }

  public static void findAllSubset(List<Integer> list, String prefix) {

    if (null != prefix && subSetSize == prefix.split(" ").length) {
      System.out.println(prefix);
    }
    if (null == list || list.isEmpty()) {
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      List<Integer> mainList = new ArrayList<>(list.subList(0, i));
      mainList.addAll(list.subList(i + 1, list.size()));
      findAllSubset(mainList, prefix+" "+list.get(i));
    }
  }

  public static void printList(List<Integer> list) {
    System.out.println();
    for (Integer i : list) {
      System.out.print(" "+i);
    }
  }
}
