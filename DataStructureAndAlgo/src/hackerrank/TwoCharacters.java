package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TwoCharacters {
  public static void main(String[] args) {
    System.out.println(find("beabeefeab"));
  }

  //beabeefeab
  public static int find(String input) {
    Set<Character> set = new HashSet<>();
    for (Character c : input.toCharArray()) {
      set.add(c);
    }
    int distinctChar = set.size();
    int maxSize = Integer.MIN_VALUE;
    List<Character> list = new ArrayList<>(set);
    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j < list.size(); j++) {
        int res = isReplace(new HashSet<Character>(Arrays.asList(list.get(i), list.get(j))),
            input);
        if (maxSize <res) {
          maxSize = res;
        }
      }
    }
    return maxSize;
  }

  public static int isReplace(Set<Character> set, String input) {
    for (Character c : input.toCharArray()) {
      if (!set.contains(c)) {
        input = input.replaceAll("" + c, "");
      }
    }
    return isAlternative(input) ? input.length() : 0;
  }


  public static Boolean isAlternative(String input) {
    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()) {
      if (!stack.isEmpty()) {
        Character top = stack.pop();
        if (!top.equals(c)) {
          stack.push(top);
          stack.push(c);
        } else {
          return Boolean.FALSE;
        }
      }else{
        stack.push(c);
      }
    }
    return true;
  }
}