package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P2 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        int extra = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + extra;
            extra = sum >= 10 ? 1 : 0;
            int val = sum >= 10 ? sum - 10 : sum;
            cur.next = new ListNode(val);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + extra;
                extra = sum >= 10 ? 1 : 0;
                int val = sum >= 10 ? sum - 10 : sum;
                cur.next = new ListNode(val);
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l2 == null) {
            while (l1 != null) {
                int sum = l1.val + extra;
                extra = sum >= 10 ? 1 : 0;
                int val = sum >= 10 ? sum - 10 : sum;
                cur.next = new ListNode(val);
                cur = cur.next;
                l1 = l1.next;
            }
        }

        // 必须判断最后是否有进位
        if (extra == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }


    /**
     * 改进，不用单独统计哪个为null，为null的直接用0代替，保持算法结构一致
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        int extra = 0;
        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1 + v2 + extra;
            extra = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (extra > 0) {
            cur.next = new ListNode(extra);
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);

        n1.next = n2;

        ListNode p1 = new ListNode(5);
        ListNode p2 = new ListNode(6);
        ListNode p3 = new ListNode(9);
        ListNode p4 = new ListNode(9);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        printList(n1);
        printList(p1);

        ListNode rst = addTwoNumbers2(n1, p1);
        printList(rst);

    }

    private static void printList(ListNode p) {
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
