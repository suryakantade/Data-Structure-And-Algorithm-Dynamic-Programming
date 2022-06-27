package com.leetcode;


import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigitsAnywhere {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            k = checkStackIfHasBigger(stack, Integer.parseInt("" + num.charAt(i)), k);
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        String actual = "";
        for (int i : stack) {
            actual += i;
        }
        return actual.isEmpty() ? "0" : actual;
    }

    public static int checkStackIfHasBigger(Stack<Integer> stack, int n, int k) {
        if (stack.size() >= 1) {
            while (!stack.empty() && stack.peek() > n && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(n);
        } else {
            stack.push(n);
        }
        if (stack.size() == 1 && stack.peek() == 0) {
            stack.pop();
        }
        return k;
    }

}
