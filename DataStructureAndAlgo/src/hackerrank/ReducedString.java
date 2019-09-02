package hackerrank;


import java.util.Stack;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/reduced-string/problem
public class ReducedString {

  public static void main(String[] args) {
    System.out.println(reducedString("aaabccddd"));
    System.out.println(reducedString("aa"));
    System.out.println(reducedString("baab"));
  }

  public static String reducedString(String input) {
    Stack<Character> stack = new Stack<>();
    for (Character s : input.toCharArray()) {
      if (stack.isEmpty()) {
        stack.push(s);
      } else {
        Character peek = stack.pop();
        if (!s.equals(peek)) {
          stack.push(peek);
          stack.push(s);
        }
      }
    }
    if (stack.isEmpty()) {
      return "Empty String";
    } else {
      String res = "";
      for (Character c : stack) {
        res += c;
      }
      return res;
    }
  }
}
