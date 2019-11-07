package com.datastructure.Array;

//https://www.geeksforgeeks.org/rearrange-array-arri/
public class RearrangeArrAsAi_i {
  public static void main(String[] args) {
    int[] arr = {-1,1,2,3,4,7,8,0,-1};
    rearrange(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(i+" -- >"+arr[i]);
    }
  }
  public static void rearrange(int[] arr){
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=i){
        for(int j=i+1;j<arr.length;j++){
          if(arr[i]!=i && i==arr[j]){
            int tmp = arr[i];
            arr[i]=arr[j];
            arr[j] = tmp;
            break;
          }else if(arr[i] != -1 && arr[j]== -1){
            int tmp = arr[i];
            arr[i]=arr[j];
            arr[j] = tmp;
          }
        }

      }
    }
  }
}
