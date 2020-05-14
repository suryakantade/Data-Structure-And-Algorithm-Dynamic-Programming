package zztest;

import java.util.Scanner;

public class OneIncrement {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int sum =0;
    for (int i =1;i<=n;i++){
      sum+=i;
    }
    System.out.println("total sum for keya : "+sum);
  }
}
