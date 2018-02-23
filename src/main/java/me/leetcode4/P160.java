package me.leetcode4;

import me.ListNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P160 {


    /**
     * 核心思路是：
     *
     * 公共的部分长度肯定是一样的，那么要找到连接点，则必须让p1和p2走一样的步数，然后同时到达连接点。那么如果p1走到头了，让他在继续走headB的道路，p2走到头了，继续走headA的道路，
     * 这样相当于p1和p2都走了headA+headB两个链表的不同的部分之和，所以一定在连接点处相遇。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
