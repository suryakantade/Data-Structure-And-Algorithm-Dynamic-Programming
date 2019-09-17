package com.datastructure.Backtracking;

public class RatAndMazeProblem {
  public static void main(String[] args) {
    int maze[][] = { { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 0, 1, 0, 0 },
        { 1, 1, 1, 1 } };
    System.out.println(findNextFreeBox(maze,maze.length-1,maze[maze.length-1].length-1));

  }
  public static Boolean findNextFreeBox(int[][] arr,int x, int y) {
    if (x == 0 && y == 0) {
      return true;
    }

    boolean isPossible = false;
    if (isValidIndex(arr, x - 1, y - 1)) {
      isPossible = findNextFreeBox(arr, x - 1, y - 1);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x - 1, y)) {
      isPossible = findNextFreeBox(arr, x - 1, y);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x - 1, y + 1)) {
      isPossible = findNextFreeBox(arr, x - 1, y + 1);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x, y - 1)) {
      isPossible = findNextFreeBox(arr, x, y - 1);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x, y + 1)) {
      isPossible = findNextFreeBox(arr, x, y + 1);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x + 1, y+1)) {
      isPossible = findNextFreeBox(arr, x + 1, y+1);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x + 1, y)) {
      isPossible = findNextFreeBox(arr, x + 1, y);
    }
    if (isPossible) {
      return isPossible;
    }
    if (isValidIndex(arr, x, y + 1)) {
      isPossible = findNextFreeBox(arr, x, y + 1);
    }
    if (isPossible) {
      return isPossible;
    }
    return isPossible;
  }
  public static boolean isValidIndex(int[][] arr, int x,int y){
    if(x<0||y<0||x>=arr.length||y>=arr[x].length||arr[x][y]==0){
      return false;
    }
    return true;
  }
}
