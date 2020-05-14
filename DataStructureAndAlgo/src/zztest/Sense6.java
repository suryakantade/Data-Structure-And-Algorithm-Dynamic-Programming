package zztest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Sense6 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    int count = 0;
    boolean isFound = true;
      while(in.hasNextLine()) {
        String input = in.nextLine();
        if(null != input && input.trim().equals("")){
          isFound = false;
        }
        if(isFound){
          count++;
        }
        list.add(input);
      }

    String[] a = new String[count];
    String[] f = new String[list.size()-count-1];
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == null || list.get(i).equals("")) {
        list.subList(0, i).toArray(a);
        list.subList(i + 1, list.size()).toArray(f);
        break;
      }
    }

    /*String[] a = new String[] {"TRAP", "CARD", "FACT", "DART"};
    String[] f = new String[] {"FACT", "CAT", "DOG"};*/


    char[][] arr = new char[a.length][a[0].length()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = a[i].toCharArray();
    }
    int l = Integer.MIN_VALUE;
    for (String s:f){
      if(l<s.length()){
        l=s.length();
      }
    }
    Map<Character, Character> startingMap = new HashMap<>();
    for (String s : f) {
      startingMap.put(s.charAt(0), s.charAt(0));
    }
    Map<String, String> dataMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (startingMap.containsKey(arr[i][j])) {
          traverseEightWay(dataMap, arr, i, j,l);
        }
      }
    }
    for (String s : f) {
      s=s.trim();
      if (dataMap.get(s) == null) {
        System.out.println(s + " " + "-1 -1");
      } else {
        System.out.println(s + " " + dataMap.get(s));
      }
    }

  }

  public static void traverseEightWay(Map<String, String> map, char[][] arr, int i, int j, int l) {
    String tmp = "";
    int lc = l;
    //s
    for (int ic = i; ic < arr.length && lc>0; ic++) {
      tmp += arr[ic][j];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    lc = l;
    //e
    for (int jc = j; jc < arr[i].length && lc>0; jc++) {
      tmp += arr[i][jc];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    lc = l;
    //se
    for (int ic = i, jc = j; ic < arr.length && jc < arr[ic].length && lc>0; ic++, jc++) {
      tmp += arr[ic][jc];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    lc = l;
    //n
    for (int ic = i; ic > -1 && lc>0; ic--) {
      tmp += arr[ic][j];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    lc = l;
    //west
    for (int jc = j; jc > -1 && lc>0; jc--) {
      tmp += arr[i][jc];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    lc = l;
    //nw
    for (int ic = i, jc = j; ic > -1 && jc > -1 && lc>0; ic--, jc--) {
      tmp += arr[ic][jc];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    //ne
    for (int jc = j, ic = i; ic > -1 && jc < arr[ic].length && lc>0; jc++, ic--) {
      tmp += arr[ic][jc];
      map.put(tmp, i + " " + j);
      lc--;
    }
    tmp = "";
    lc = l;
    //sw
    for (int ic = i, jc = j; ic < arr.length && jc > -1 && lc>0; ic++, jc--) {
      tmp += arr[ic][jc];
      map.put(tmp, i + " " + j);
      lc = l;
    }
  }
}

