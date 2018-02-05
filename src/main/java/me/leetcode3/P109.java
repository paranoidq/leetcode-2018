package me.leetcode3;

import me.ListNode;
import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P109 {


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;

        // head == tail时返回null
        if (head == tail) {
            return null;
        }

        // 通过快慢指针找到中间节点 这里注意while中条件的比较是基于tail，而不是null
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 递归生成左子树和右子树
        TreeNode curRoot = new TreeNode(slow.val);
        curRoot.left = helper(head, slow);
        curRoot.right = helper(slow.next, tail);
        return curRoot;
    }
}
