package me.leetcode3;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P147 {


    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode helper = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;    // 先保存迭代的下一个元素

            // 找插入位置pre.next
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            // 应该插入pre 和 pre.next之间
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            pre = helper;  // 回到开头位置
        }
        return helper.next;
    }
}
