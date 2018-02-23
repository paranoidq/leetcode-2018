package me.leetcode3;

import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P150 {

    public String operands = "+-*/";

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (operands.indexOf(token) == -1) {
                // 数字
                stack.push(token);
            } else {
                Integer n2 = Integer.parseInt(stack.pop());
                Integer n1 = Integer.parseInt(stack.pop());

                if (token.equals("+")) {
                    stack.push(Integer.toString(n1 + n2));
                } else if (token.equals("-")) {
                    stack.push(Integer.toString(n1 - n2));
                } else if (token.equals("*")) {
                    stack.push(Integer.toString(n1 * n2));
                } else if (token.equals("/")) {
                    stack.push(Integer.toString(n1 / n2));
                }
            }
        }
        if (stack.size() != 1) {
            throw new IllegalStateException("表达式错误");
        } else {
            return Integer.parseInt(stack.pop());
        }

    }

    public static void main(String[] args) {
        String[] el = {"4", "13", "5", "/", "+"};
        System.out.println(new P150().evalRPN(el));
    }
}
