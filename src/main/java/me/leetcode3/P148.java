package me.leetcode3;

import me.ListNode;
import me.leetcode1.P1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // cut list to 2 halves
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;      // 这一步非常关键，彻底切断两半部分的联系，否则很难处理结束条件

        // sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // merge
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            // 无论是选l1还是l2,p都要往前走
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }
}
