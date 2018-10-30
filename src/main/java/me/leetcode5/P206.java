package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P206 {

    static public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解法1：current始终指向原表的第一个的节点，变化的current.next节点，每次reverse一个位置
     * current
     * |
     * L -> 1 -> 2 -> 3 -> 4
     *
     * phase1:
     * current
     * |
     * L -> 2 -> 1 -> 3 -> 4
     *
     * </tt>
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode current = head;
        ListNode p;

        while (current.next != null) {
            p = current.next;
            current.next = p.next;
            p.next = dummy.next;
            dummy.next = p;
        }
        return dummy.next;
    }


    /**
     * 解法1：current始终指向新表的第一个的节点，变化是pnext节点，中途原链表会断开，while迭代考的就是pnext节点
     * current
     * |
     * L -> 1 -> 2 -> 3 -> 4
     *
     * phase1:
     * current pnext
     * |      |
     * L -> 2      1 -> 3 -> 4
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode pnext = current.next;
        ListNode ppnext;
        current.next = null;
        while (pnext != null) {
            ppnext = pnext.next;
            pnext.next = current;
            current = pnext;
            pnext = ppnext;
        }
        return current;
    }


    public ListNode reverseList3(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode p, ListNode newListHead) {
        if (p == null) {
            return newListHead;
        }
        ListNode next = p.next;
        p.next = newListHead;
        return reverse(next, p);
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ListNode rst = new P206().reverseList2(p1);

        ListNode p = rst;
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
    }
}
