package zztest;

public class CoumpundInterest {

  public static void main(String[] args) {
    findCompund(11000000, 10, 3);
  }

  // 100 10 3
  //1-> 110
  //2-> 121
  //3-> 133.1
  public static float findCompund(float totalAmt, int interestRate, int noOfYrs) {
    //p(1+r/100)^n
    for (int i = 0; i < noOfYrs; i++) {
      totalAmt = totalAmt + (totalAmt * interestRate / 100);
      System.out.println("year: " + (i + 1) + " totalAmt: " + totalAmt);
    }
    return totalAmt;
  }
}
