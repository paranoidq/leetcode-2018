package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P237 {

    static public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 只能通过覆盖值的方式
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode pnext = node.next;
        while (pnext.next != null) { // 直到pnext为最后一个节点
            node.val = pnext.val;
            node = pnext;
            pnext = pnext.next;
        }
        node.val = pnext.val;
        node.next = null;
    }

    /**
     * 但是上面的想法复杂了，其实只要用后面的值覆盖一下，delete掉后面的node就行了
     * 完全没必要用while迭代到链表的末尾！！！
     *
     * @param node
     */
    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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

        new P237().deleteNode(p2);

        ListNode p = p1;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
