package me.leetcode3;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 注意检查子节点为null的情况，与maxDepth的处理不同
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else {
            return minDepth(root.left) + 1;
        }
    }

}
