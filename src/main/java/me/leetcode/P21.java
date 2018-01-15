package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(4);
//        ListNode p4 = new ListNode(4);
//        ListNode p5 = new ListNode(5);

        p1.next = p2;
        p2.next = p3;
//        p3.next = p4;
//        p4.next = p5;


        ListNode p6 = new ListNode(1);
        ListNode p7 = new ListNode(3);
        ListNode p8 = new ListNode(4);
        p6.next = p7;
        p7.next = p8;

        print(p1);
        print(p6);

        ListNode ans = mergeTwoLists(p1, p6);

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
