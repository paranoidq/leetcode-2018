package me.leetcode;

import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("{[(".indexOf(ch) != -1) {
                stack.push(ch);
            } else if (
                // wrong case: "]"，此时会EmptyStackException，要注意检查
                stack.isEmpty() ||
                (ch == ']' && stack.peek() != '[') ||
                (ch == ')' && stack.peek() != '(') ||
                (ch == '}' && stack.peek() != '{')
                ) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[";
        System.out.println(isValid(str));
    }
}
