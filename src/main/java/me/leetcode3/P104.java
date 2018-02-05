package me.leetcode3;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // BFS，找出层数，即为最大深度
    // O(n)复杂度，必须遍历每一个节点
    public int maxDepth2(TreeNode root) {
        return new P102().levelOrder(root).size();
    }

}
