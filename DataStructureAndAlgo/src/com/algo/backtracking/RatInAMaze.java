package com.algo.backtracking;

import java.util.LinkedList;
import java.util.List;

//https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
public class RatInAMaze {
  public static void main(String[] args) {

    int[][] mat = {{1, 1, 0, 0},
                    {0, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}};
    List<String> path = new LinkedList<>();
    System.out.println(findPath(mat, 0, 0, path)+"   and path : "+path);

  }


  public static boolean findPath(int[][] mat, int x, int y, List<String> path) {
    if (!isValidPosition(mat, x, y)) {
      return false;
    }
    if (mat[x][y] == 0) {
      return false;
    }
    mat[x][y] = 0;
    if (x == mat.length - 1 && y == mat[x].length - 1) {
      path.add(getCoordinateToString(x, y));
      return true;
    }
    if (findPath(mat, x, y - 1, path)) {
      path.add(getCoordinateToString(x, y));
      return true;
    }
    if (findPath(mat, x, y + 1, path)) {
      path.add(getCoordinateToString(x, y));
      return true;
    }
    if (findPath(mat, x - 1, y, path)) {
      path.add(getCoordinateToString(x, y));
      return true;
    }
    if (findPath(mat, x + 1, y, path)) {
      path.add(getCoordinateToString(x, y));
      return true;
    }

    return false;
  }

  public static boolean isValidPosition(int[][] mat, int x, int y) {
    if (x < 0 || x >= mat.length || y < 0 || y >= mat[x].length) {
      return false;
    }
    return true;
  }

  public static String getCoordinateToString(int x, int y) {
    return "(" + x + "," + y + ")";
  }
}
