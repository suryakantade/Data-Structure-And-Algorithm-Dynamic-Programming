package com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class DijkstrasAlgo {
  public static void main(String[] args) {
    int graph[][] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    findShortest(graph);
  }

  public static void findShortest(int[][] mat) {
    List<GraphNode> nodes = new ArrayList<>();
    for (int i = 0; i < mat.length; i++) {
      if (i == 0) {
        nodes.add(new GraphNode(0, false, -1));
      } else {
        nodes.add(new GraphNode(Integer.MAX_VALUE/2, false, -1));
      }
    }
    int lowestWeightIndex = findLowest(nodes);
    int traversedCount = 1;
    while (traversedCount <= mat.length) {
      nodes.get(lowestWeightIndex).isVisited = true;
      for (int i = lowestWeightIndex; i < mat.length; i++) {
        if (mat[lowestWeightIndex][i] != 0 &&
            nodes.get(i).w > nodes.get(lowestWeightIndex).w + mat[lowestWeightIndex][i]) {
          nodes.get(i).w = nodes.get(lowestWeightIndex).w + mat[lowestWeightIndex][i];
          nodes.get(i).parent = lowestWeightIndex;
        }
      }
      lowestWeightIndex = findLowest(nodes);
      traversedCount++;
    }
    for (int i =0;i<nodes.size();i++){
      System.out.println(nodes.get(i).parent +" --->  "+nodes.get(i).w);
    }
  }

  public static int findLowest(List<GraphNode> nodes) {
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    for (int i = 0; i < nodes.size(); i++) {
      if (nodes.get(i).w < min && nodes.get(i).isVisited == false) {
        min = nodes.get(i).w;
        minIndex = i;
      }
    }
    return minIndex;
  }
}


class GraphNode {
  public int w;
  public boolean isVisited;
  public int parent;

  public GraphNode(int w, boolean isVisited, int parent) {
    this.w = w;
    this.isVisited = isVisited;
    this.parent = parent;
  }
}