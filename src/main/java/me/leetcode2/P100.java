package me.leetcode2;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P100 {

    // 递归遍历子树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
