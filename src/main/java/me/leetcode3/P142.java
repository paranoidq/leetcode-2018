package me.leetcode3;

import me.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            } else {
                set.add(p);
                p = p.next;
            }
        }
        return p;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        boolean hasCycle = false;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            p1 = head;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
        return null;
    }
}
