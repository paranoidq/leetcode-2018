package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P82 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode i = dummyHead;
        ListNode p = i.next.next;

        // 记录前面扫过的元素否重复
        boolean dup = false;
        while (p != null) {
            if (p.val != i.next.val) {
                if (dup) {
                    i.next = p;
                    p = p.next;
                } else {
                    i = i.next;
                    p = p.next;
                }
                // 需要恢复dup为false
                dup = false;
            } else {
                p = p.next;
                dup = true;
            }
        }
        // 注意结尾边界情况
        if (dup) {
            i.next = null;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(1);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        ListNode ans = new P82().deleteDuplicates(p1);
        ListNode p = ans;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }

}
