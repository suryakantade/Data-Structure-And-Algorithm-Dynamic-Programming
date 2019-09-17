package com.datastructure.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RemoveInvalidParanthesys {

  public static void main(String[] args) {
    findPossibleWIthOutInvalid("()())()");

  }

  public static void findPossibleWIthOutInvalid(String s) {
    Map<Character, Character> map1 = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    map1.put(')', '(');
    map2.put('(', ')');
    Stack<Character> stack = new Stack<>();
    Stack<Character> reverseStack = new Stack<>();
    List<String> list = new ArrayList<>();
    String possibleString1 = "";
    String possibleString2 = "";
    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty()) {
        Character c = stack.pop();
        if (!c.equals(map1.get(s.charAt(i)))) {
          stack.push(c);
          stack.push(s.charAt(i));
        } else {
          possibleString1 += c + "" + s.charAt(i);
        }
      } else {
        stack.push(s.charAt(i));
      }
      //reverse traverse
      if (!reverseStack.isEmpty()) {
        Character c = reverseStack.pop();
        if (!c.equals(map2.get(s.charAt(s.length() - 1 - i)))) {
          reverseStack.push(c);
          reverseStack.push(s.charAt(s.length() - 1 - i));
        } else {
          possibleString2 = s.charAt(s.length() - 1 - i) + "" + c + possibleString2;
        }
      } else {
        reverseStack.push(s.charAt(s.length() - 1 - i));
      }
    }
    System.out.println(possibleString1 + " ---  " + possibleString2);
  }

}
