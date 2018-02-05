package me.leetcode2;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P92 {

    // 此处题设m和n都是合法的，所以不用检查null的边界条件
    // 如果没有假设合法，如何检查边界条件？？？
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // asserts m and n valid
        if (m == n) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode mPre = dummyHead;
        int i = 1;
        for (; i < m; i++) {
            mPre = mPre.next;
        }
        ListNode p = mPre.next;
        ListNode pNext;
        for (; i < n; i++) {
            pNext = p.next;
            p.next = p.next.next;
            pNext.next = mPre.next;
            mPre.next = pNext;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        reverseBetween(p1, 2, 4);
        ListNode p = p1;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
