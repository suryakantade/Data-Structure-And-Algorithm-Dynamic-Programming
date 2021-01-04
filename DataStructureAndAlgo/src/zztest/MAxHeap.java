package zztest;



import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MAxHeap {
  PriorityQueue<Integer> store = null;
  int size = 0;

  public MAxHeap(int k) {
    this.store = new PriorityQueue<>();
    this.size = k;
  }

  //k = 2
  //5
  //2
  public void insert(Integer n) {
    if (store.size() >= this.size) {
      if (store.peek() < n) {
        store.poll();
        this.store.add(n);
      } else {
        //skip
      }
    } else {
      this.store.add(n);
    }
  }

  public int findKthSmallest() {
    return this.store.peek();
  }

  public int knight(int m, int n, int a, int b, int x, int y) { 
    int[][] mat = new int[m][n];
    //for(){}
    //todo:

  }

  //x+2,y+1
  //x+2,y-1
  //x-2,y+1
  //x-2,y-1
  //x+1,y+2
  //x+1, y-2
  //x-1,y+2
  //x-1, y-2


  public int findShortest(int[][] mat, int a, int b, int x, int y) {
    int[] xDir = {2, 2, -2, -2, 1, 1, -1, -1} ;
    int[] yDir = {1, -1, 1, -1, 2, -2, 2, -2};
    Queue<Pair> queue = new LinkedList<>();
    ((LinkedList<Pair>) queue).add(new Pair(a, b, 0));
    while (!queue.isEmpty()) {
      Pair tmp = queue.poll();
      if (tmp.left == x && tmp.right == y) {
        return tmp.pos;
      }
      for (int i = 0; i < xDir.length; i++) {
        if (isValidCoordinate(mat, mat.length, mat[a].length, tmp.left + xDir[i],
            tmp.right + yDir[i])) {
          ((LinkedList<Pair>) queue)
              .add(new Pair(tmp.left + xDir[i], tmp.right + yDir[i], tmp.pos + 1));
        }
      }
    }
    return -1;
  }

//int[] xDir = {2,2,-2,-2,1,1,-1,-1} int [] yDir = {1,-1,1,-1,2,-2,2,-2}
  public boolean isValidCoordinate(int[][] mat, int m, int n, int x, int y) {
    boolean isValid = true;
    if (x<0 || y<0 || x > m || y > n || mat[x][y]==1) {
      isValid = false;
    }
    return isValid;
  }


}

class Pair{
  int left;
  int right;
  int pos;

  public Pair(int left, int right, int pos) {
    this.left = left;
    this.right = right;
    this.pos = pos;
  }
}
/*
 * Given a  source point (A, B) and a destination point (X, Y) on a chess board of a given size,
 * we need to find whether Knight(Horse) can move to the destination or not.  if yes,
 * retrun the minimum number of steps required, else return -1.
 *
 * */




