package com.datastructure.Matrix;

//https://www.geeksforgeeks.org/sum-of-all-submatrices-of-a-given-matrix/
public class SumOfSubMatrix {
  public static void main(String[] args) {
    int arr[][] = {{1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}};
    System.out.println(sumOfAllSubMatrix(arr));
  }

  /*1 2 3
   * 4 5 6
   * 7 8 9*/
  public static int sumOfAllSubMatrix(int[][] arr) {
    int sum =0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sum+=findRange(arr,i,j);
      }
    }
    return sum;
  }


  public static int findRange(int[][] arr, int x, int y) {
    int sum = 0;
    for (int i = x; i < arr.length; i++) {
      for (int j = y; j < arr[i].length; j++) {
        sum+=findSumForGivenRange(arr,x,y,i,j);
      }
    }
    return sum;
  }
  /*1+ *+ *+
   *+ *+ * 6
   * 7 8 9*/
  public static int findSumForGivenRange(int[][] arr, int x,int y,int x1,int y1){
    int sum =0;
    for(int i =x;i<=x1;i++){
      for (int j =y;j<=y1;j++){
        sum+=arr[i][j];
      }
    }
    return sum;
  }
}
