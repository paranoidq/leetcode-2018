package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P234 {

    static public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 奇数个节点的时候，slow正好处于中间节点的位置，要跳过
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        // 此时fast重新指向head，slow指向reverse后的后半部分
        // 逐个比较即可
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }


    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

