package zztest;

public class RegexCheck {

  public static void main(String[] args) {
    String start = "a..s";
    String regex = "\\.(?=.*\\.)";
    String end = start.replaceAll(regex, "");
    System.out.println(end);
  }
}
