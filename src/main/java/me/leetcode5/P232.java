package me.leetcode5;

import java.util.Stack;

/**
 * 解释：
 * s1专门用于push，s2专门用于pop
 *
 * push的时候，直接往s1压
 * pop的时候，检查s2有没有内容，有就直接从s2 pop，没有就从s1全部压过来
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P232 {

    public class MyQueue {

        private Stack<Integer> sPush;
        private Stack<Integer> sPop;

        /** Initialize your data structure here. */
        public MyQueue() {
            sPush = new Stack<>();
            sPop = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            sPush.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return sPop.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!sPop.isEmpty()) {
                return sPop.peek();
            }

            // s2空
            while (!sPush.isEmpty()) {
                sPop.push(sPush.pop());
            }
            return sPop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return sPush.isEmpty() && sPop.isEmpty();
        }
    }
}
