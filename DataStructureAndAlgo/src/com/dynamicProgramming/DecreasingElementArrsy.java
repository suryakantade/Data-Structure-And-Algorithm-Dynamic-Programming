package com.dynamicProgramming;

import java.util.Scanner;

public class DecreasingElementArrsy {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Integer input = s.nextInt();

    for (int mm = 0; mm < input; mm++) {
      Integer noOfIp = s.nextInt();
      int[] arr = new int[noOfIp];
      for (int j = 0; j < noOfIp; j++) {
        arr[j] = s.nextInt();
      }
      int sum =0;
      for (int j = arr.length - 1; j >= 0; j--) {
        sum+=arr[j];
        if(j>0) {
          if (arr[j - 1] > arr[j]) {
            arr[j - 1] = arr[j];
          }
        }
      }
      System.out.println(sum);
    }
  }
}