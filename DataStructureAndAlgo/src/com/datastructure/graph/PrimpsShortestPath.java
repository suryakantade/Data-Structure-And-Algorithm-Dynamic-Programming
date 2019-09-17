package com.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class PrimpsShortestPath {
  public static void main(String[] args) {
    int graph[][] =
        {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};
    primpMst(graph);

  }

  public static void primpMst(int[][] graph) {
    NodeAttribute[] nodeAttributes = new NodeAttribute[graph.length];
    List<Integer> lis = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      NodeAttribute nodeAttribute = null;
      if (i == 0) {
        nodeAttribute = new NodeAttribute(true, -1, 0);
      } else {
        nodeAttribute = new NodeAttribute(false, -1, Integer.MAX_VALUE);
      }
      nodeAttributes[i] = nodeAttribute;

    }
    for (int i = 0; i < graph.length; i++) {
      int minIndex = findMin(nodeAttributes);
      nodeAttributes[minIndex].setVisited(true);
      for (int j = minIndex; j < graph.length; j++) {
        if (graph[minIndex][j] != 0 && nodeAttributes[j].distance < graph[minIndex][j]) {
          nodeAttributes[j].parent = minIndex;
          nodeAttributes[j].distance = graph[minIndex][j];
        }
      }
    }
    print(graph, nodeAttributes);
  }

  public static int findMin(NodeAttribute[] arr) {
    Integer max = Integer.MAX_VALUE;
    int minIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].isVisited == false && arr[i].distance < max) {
        max = arr[i].distance;
        minIndex = i;
      }
    }
    return minIndex;
  }

  public static void print(int[][] graph, NodeAttribute[] attributes) {
    for (int i = 0; i < graph.length; i++) {
      System.out.println(attributes[i].parent + " ---> " + graph[i][attributes[i].parent]);
    }
  }
}


class NodeAttribute {
  public boolean isVisited;
  public int parent;
  public int distance;

  public NodeAttribute(boolean isVisited, int parent, int distance) {
    this.isVisited = isVisited;
    this.parent = parent;
    this.distance = distance;
  }

  public int getParent() {
    return parent;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }
}

