package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DetachProblem {


  int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
    int[][] arr = new int[rows][column];
    int[][] visitedArr = new int[rows][column];
    int count =0;
    for (int j = 0; j < grid.size(); j++) {
      for (int i = 0; i < grid.get(j).size(); i++) {
        arr[i][j] = grid.get(j).get(i);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (visitedArr[i][j] == 0 && arr[i][j] == 1) {
          visitedArr[i][j] = 1;
          findNeighbourAndMark(arr,visitedArr,i,j);
          count++;
        }
      }
    }
    return count;
  }

  public static void findNeighbourAndMark(int[][] mainArr, int[][] visitedArr, int x, int y) {
    if (isNotOutOfRange(mainArr,x+1,y,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x+1, y );
    }

    if (isNotOutOfRange(mainArr,x,y+1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x, y+1);
    }

    if (isNotOutOfRange(mainArr,x-1,y,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x-1, y);
    }

    if (isNotOutOfRange(mainArr,x,y-1,visitedArr)) {
      findNeighbourAndMark(mainArr, visitedArr, x, y-1);
    }

  }

  public static boolean isNotOutOfRange(int[][] arr, int x, int y, int[][] visitedArr) {
    if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && visitedArr[x][y] != 1
        && arr[x][y] == 1) {
      visitedArr[x][y] = 1;
      return true;
    }
    return false;
  }


  List<Integer> criticalRouters(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < links.size(); i++) {
      List<Integer> lis = map.get(links.get(i).get(0));
      if (null == lis) {
        lis = new ArrayList<>();
      }
      lis.add(links.get(i).get(1));
      List<Integer> lis1 = map.get(links.get(i).get(0));
      if (null == lis1) {
        lis1 = new ArrayList<>();
      }
      lis1.add(links.get(i).get(0));

      map.put(links.get(i).get(0), lis);
      map.put(links.get(i).get(1), lis1);
    }
    List<Integer> res= new ArrayList<>();
    if (map.size() > 0) {
      for (Integer i : map.keySet()) {
        int cur = map.get(i).get(0);
        Queue<Integer> q = new LinkedList<>();
        ((LinkedList<Integer>) q).push(cur);
        int count = 0;
        Map<Integer, Boolean> visited = new HashMap<>();
        while(!q.isEmpty()){
          cur = ((LinkedList<Integer>) q).pop();
          if(null == visited.get(cur)) {
            q.addAll(map.get(cur));
            count++;
            visited.put(cur, Boolean.TRUE);
          }
        }
        if(count <numRouters-1){
          res.add(cur);
        }

      }
    }
    return res;
  }
}
