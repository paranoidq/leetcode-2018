package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P203 {

    public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode p = dumy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }

        }

        return dumy.next;
    }
}
