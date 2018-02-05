package me.leetcode3;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = Math.abs(depth(root.left) - depth(root.right));
        if (diff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }


    // 直接在dfs中返回当前节点的深度
    // 如果发现其中有一个节点造成了非balanced，那么会一直向上层返回-1, 通过这个-1，可以避免向下的递归计算
    // 避免了每个节点都要计算一次depth的重复开销

    // 该算法的复杂度降为o(n)，而上面的算法，每个节点都要一次depth，而depth又需要o(n)的复杂度，因此复杂度是o(n^2)
    private int depth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth2(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = depth2(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
