package me.leetcode5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解法1：使用一个queue，push的时候先push(x)，然后将最后一个x除外的都取出重新push一遍，保证x成为了第一个元素
 *
 * 解法2：两个队列，每次push的时候直接push到非空的那个队列，pop的时候将除了最后一个元素外的挪到另一个队列，然后最后一个出队即可
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P225 {

    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> q = q1;
            if (q1.isEmpty()) {
                q = q2;
            }
            q.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> q = q1;
            Queue<Integer> qTmp = q2;
            if (q1.isEmpty()) {
                q = q2;
                qTmp = q1;
            }

            while (q.size() > 1) {
                qTmp.add(q.poll());
            }
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            Queue<Integer> q = q1;
            Queue<Integer> qTmp = q2;
            if (q1.isEmpty()) {
                q = q2;
                qTmp = q1;
            }
            while (q.size() > 1) {
                qTmp.add(q.poll());
            }
            int x = q.poll();
            qTmp.add(x);
            return x;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }
}
