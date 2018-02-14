package me.leetcode3;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P114 {


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }

    private TreeNode pre = null;
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        pre = root;

        TreeNode right = root.right;
        if (root.left != null) {
            helper(root.left);
        }

        if (right != null) {
            helper(right);
        }
    }
}
