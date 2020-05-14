package com.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShopVisitProblem {


  // Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


  public static void main(String args[]) throws Exception {

    //Scanner
    Scanner s = new Scanner(System.in);
    Integer input = s.nextInt();                 // Reading input from STDIN

    for (int mm = 0; mm < input; mm++) {
      int[] arr = new int[1000000];
      // Adding +1 at Li index and
      // substracting 1 at Ri index.
      int maxi = -1;
      Integer noOfShops = s.nextInt();
      Integer noOfUser = s.nextInt();
      for (int j = 0; j < noOfUser; j++) {
        Integer l = s.nextInt();
        Integer r = s.nextInt();
        l=l<1?1:l;
        r=r>noOfShops?noOfShops:r;
        arr[l] += 1;
        arr[r + 1] -= 1;
        if (r > maxi) {
          maxi = r;
        }
      }
      int fsum = arr[0];
      int smax = 0;
      int tMax = 0;
      int find = 0;
      int sind = 0;
      int tind = 0;

      for (int i = 1; i < maxi + 1; i++) {
        arr[i] += arr[i - 1];
        if (fsum < arr[i]) {
          tMax = smax;
          smax = fsum;
          fsum = arr[i];
          tind = sind;
          sind = find;
          find = i;
        } else if(smax < arr[i]){
          tMax = smax;
          smax = arr[i];
          tind = sind;
          sind = i;
        } else if(tMax<arr[i]){
          tMax = arr[i];
          tind = i;
        }
      }
      List<Integer> li = Arrays.asList(find,sind,tind);
      Collections.sort(li);
      System.out.println(li.get(0) + " " + li.get(1) + " " + li.get(2));

    }

    // Finding prefix sum and index
    // having maximum prefix sum.

  }


}

