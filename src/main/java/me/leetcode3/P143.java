package me.leetcode3;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P143 {

    //TLE
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode p = head;
        while (p != null) {
            p.next = reverse(p.next);
            p = p.next;
        }
    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = head;
        ListNode pNext;
        while (p.next != null) {
            pNext = p.next;
            p.next = pNext.next;
            pNext.next = dummyHead.next;
            dummyHead.next = pNext;
        }
        return dummyHead.next;
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // find the middle
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse second half
        ListNode preMiddle = p1;
        ListNode p = p1.next;
        while (p.next != null) {
            ListNode pNext = p.next;
            p.next = pNext.next;
            pNext.next = preMiddle.next;
            preMiddle.next = pNext;
        }

        // start reorder
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            // 将p1 -> p2，并保存原始链表的完整性
            // preMiddle的next始终指向未处理的后半部分的头结点
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;

            // 重新确定下一轮的p1、p2位置
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }



    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        new P143().reorderList(p1);

        ListNode p = p1;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }

}
