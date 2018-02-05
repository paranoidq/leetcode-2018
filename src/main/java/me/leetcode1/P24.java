package me.leetcode1;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;

        // 操作链表指针
        while (p != null) {
            if (p.next == null || p.next.next == null) {
                return dummyHead.next;
            } else {
                ListNode a1 = p.next;
                ListNode a2 = p.next.next;

                a1.next = a2.next;
                a2.next = a1;
                p.next = a2;
                p = a1;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        print(p1);

        ListNode ans = swapPairs(p1);
        print(ans);
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
