package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P61 {

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        // 注意k可能大于链表的长度，k等于链表长度时，无需旋转
        k = k % (count);
        if (k == 0) {
            return head;
        }

        // 通过dummyHead来减少条件判断
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        // 必须要获得倒数第k个节点的前一个节点，否则无法将前一个节点的next置为null
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        dummyHead.next = p1.next;
        p2.next = head;
        p1.next = null; // 不设置会造成环形链表
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode ans = rotateRight(n1, 0);
        printList(ans);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
