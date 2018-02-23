package me.leetcode4;

import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P155 {

    public static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> min;


        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<>();
            this.min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty() || x <= getMin()) {
                min.push(x);
            }
        }

        public void pop() {
            if (stack.peek() == getMin()) {
                min.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }


    // 解法2：只需要一个stack

//    public static class MinStack {
//
//        Integer min = Integer.MAX_VALUE;
//        Stack<Integer> stack;
//
//
//        /** initialize your data structure here. */
//        public MinStack() {
//            this.stack = new Stack<>();
//        }
//
//        public void push(int x) {
//            if (x <= min) {
//                stack.push(min);
//                min = x;
//            }
//            stack.push(x);
//        }
//
//        public void pop() {
//
//        }
//
//        public int top() {
//            return stack.peek();
//        }
//
//        public int getMin() {
//            return min.peek();
//        }
//    }


}
