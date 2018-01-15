package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 题设n是合法的
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 通过增加一个dummy头结点，来避免移除的元素是head时要进行判断
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        print(p1);
        ListNode ans = removeNthFromEnd(p1, 5);
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
