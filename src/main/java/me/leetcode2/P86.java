package me.leetcode2;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P86 {

    // 两个指针，扫描链表


    // 变种？？？快速排序？？？
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyLeft = new ListNode(-1);
        ListNode left = dummyLeft;
        ListNode dummyRight = new ListNode(-1);
        ListNode right = dummyRight;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                left.next = p;
                left = left.next;
            } else {
                right.next = p;
                right = right.next;
            }
            p = p.next;
        }

        right.next = null;
        left.next = dummyRight.next;
        return dummyLeft.next;
    }

    public static void main(String[] args) {

    }
}
