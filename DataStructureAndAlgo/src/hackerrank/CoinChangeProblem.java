package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/coin-change/problem
public class CoinChangeProblem {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Long> c = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      long cItem = Long.parseLong(cTemp[i]);
      c.add(cItem);
    }

    // Print the number of ways of making change for 'n' units using coins having the values
    // given by 'c'

    long ways = Result.getWays(n, c);

    bufferedWriter.write(String.valueOf(ways));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}


class Result {

  /*
   * Complete the 'getWays' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. LONG_INTEGER_ARRAY c
   */

  public static long getWays(int n, List<Long> c) {
    // Write your code here
    int count = 0;
    Set<List<Long>> lists = new HashSet<>();
    for (int i = c.size() - 1; i >= 0; i--) {
      boolean isDivisible = false;
      if (n % c.get(i) == 0) {
        count++;
        isDivisible = true;
      }
      for (int j = 1; j <= (isDivisible ? (n / c.get(i))   : ((n / c.get(i)) + 1)); j++) {

      }
    }
    return 1l;
  }
}


