package me.leetcode2;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode i = head;
        ListNode p = i.next;
        while (p != null) {
            if (p.val != i.val) {
                i.next = p;
                i = i.next;
                p = p.next;
            } else {
                p = p.next;
            }
        }
        // 注意最后一个元素重复的情况，需要将i.next置为null
        i.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        ListNode ans = new P83().deleteDuplicates(p1);
        ListNode p = ans;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
