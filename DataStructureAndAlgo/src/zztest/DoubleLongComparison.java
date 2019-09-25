package zztest;

public class DoubleLongComparison {
  public static void main(String[] args) {
    Double d = 1234567.0;
    Long l = 1234567l;
    System.out.println(d<=l);
    d = l>0?l:0.123;
    System.out.println(d);
  }

}
