package zztest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ZoTest {

  public static void main(String[] args) {

    //threePalindromicSubstrings("madamciviclevel");
  }

  public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins)  {
    // Write your code here

    int dp[][]= new int[1001][1001];

    int i, e, n = energy.size();

    for(i = n - 1; i >= 0; --i) {
      for(e = 0; e <= n; ++e) {
        if(i == n - 1) {
          dp[i][e] = coins.get(i);
        } else {
          dp[i][e] = dp[i + 1][Math.min((e + energy.get(i) - 1)<0?0:(e + energy.get(i) - 1), n)];
          if(e - 1 >= 0) {
            dp[i][e] = Math.max(dp[i][e], coins.get(i) + dp[i + 1][e - 1]);
          }
          if(e == 0) {
            dp[i][e] = Math.max(dp[i][e], coins.get(i));
          }
        }
      }
    }
    int ene = (int) Math.min((long)n, initialEnergy);
    return dp[0][ene];
  }


  //madam civic level
  public static List<String> threePalindromicSubstrings(String word) {
    Stack<String> stack = new Stack<>();
    findPalindrome(0, 0, word, 2, stack);
    if (stack.size() < 3) {
      return Arrays.asList("Impossible");
    } else {
      return new ArrayList<>(stack);
    }
  }

  public static boolean findPalindrome(int startIndex, int endIndex, String word, int remNo,
      Stack<String> stack) {
    if (remNo < 0 || endIndex >= word.length()) {
      return false;
    }
    boolean isPalin = isPalin(startIndex, endIndex, word);
    if (!isPalin) {
      if (remNo == 0) {
        return false;
      }
      return findPalindrome(startIndex, endIndex + 1, word, remNo, stack);
    } else {

      //System.out.println(word.substring(startIndex, endIndex + 1));
      stack.push(word.substring(startIndex, endIndex + 1));
      //System.out.println(stack);
      if (remNo == 0) {
        return true;
      }
      boolean a = true;
      if (remNo == 1) {
        a = findPalindrome(endIndex + 1, word.length() - 1, word, remNo - 1, stack);
      } else {
        a = findPalindrome(endIndex + 1, endIndex + 1, word, remNo - 1, stack);
      }
      if (a == false) {
        stack.pop();
        a = findPalindrome(startIndex, endIndex + 1, word, remNo, stack);
      }
      return a;
    }
  }

  public static boolean isPalin(int start, int end, String word) {
    for (int i = start; i <= end; i++) {
      if (word.charAt(i) != word.charAt(end)) {
        return false;
      }
      end--;
    }
    return true;
  }
}
