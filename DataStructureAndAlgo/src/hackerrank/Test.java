package hackerrank;

import java.io.IOException;

import java.io.*;
    import java.math.*;
    import java.security.*;
    import java.text.*;
    import java.util.*;
    import java.util.concurrent.*;
    import java.util.regex.*;

public class Test {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
  }

  // Complete the entityExpansion function below.
  static void entityExpansion(long l, List<String> entities) {
    int size = 0;
    for (int i = 0; i < entities.size(); i++) {
      String sub = entities.get(0).split(" ")[entities.get(0).split(" ").length - 1];
      if (sub.contains(";")) {
        size += sub.split(";").length;
      } else {
        size += 1;
      }
    }
    if (size > l) {
      System.out.println(0 + ", " + "" + size);
    } else {
      System.out.println(1 + " " + "" + size);
    }

  }
}

