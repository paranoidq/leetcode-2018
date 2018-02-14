package me.leetcode3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P116 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelNodes = q.size();

            TreeLinkNode pre = null;
            TreeLinkNode cur = null;
            for (int i = 0; i < levelNodes; i++) {
                cur = q.poll();

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }

                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
            cur.next = null;
        }
    }
}
