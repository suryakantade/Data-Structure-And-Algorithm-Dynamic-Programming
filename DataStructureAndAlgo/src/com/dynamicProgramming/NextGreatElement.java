package com.dynamicProgramming;

public class NextGreatElement {
  public static int a =0;
  public static void main(String[] args) {
    Integer a ;
    int i = 123;
    //float mmm = 0x_10.1;


    System.out.println("strawberries".substring(2,5));

//    int[] arr = {5,4,6,7,8,5,9};
//    System.out.println(nextGreaterElements(arr));
  }
  public static int nextGreaterElements(int[] arr){
    int min = Integer.MAX_VALUE;
    int count =0;
    for(int i=0;i<arr.length;i++){
      if(i==0){
        min = arr[i];
      }else{
        if(min<arr[i]){
          count++;
        }else{
          min = arr[i];
        }
       // Integer.MAX_VALUE
      }
    }
    return count;
  }
  public static Exception m(){

    String s = "\"ANCde\"";
    System.out.println(s.substring(3,4));
    return new Exception("");

  }
}
