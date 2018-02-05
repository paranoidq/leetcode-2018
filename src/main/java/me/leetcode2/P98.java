package me.leetcode2;

import me.TreeNode;

import java.util.Stack;

/**
 * http://www.cnblogs.com/yuzhangcmu/p/4177047.html
 *
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P98 {

    // 解法1：中序遍历，检查遍历节点是否满足递增
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) {
                return false;
            }


            pre = cur;
            // go to the right node
            cur = cur.right;
        }

        return true;
    }

    // 解法2：我们可以设置上下bound，递归左右子树时，为它们设置最大值，最小值，并且不可以超过。
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 避免整形最大最小值的节点，所以这里的起始要用long
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }
        if (root.val >= upperBound || root.val <= lowerBound) {
            return false;
        }

        // 注意这里向下递归时lowerBound和upperBound的设定
        return helper(root.left, lowerBound, root.val) && helper(root.right, root.val, upperBound);
    }

    private TreeNode pre = null;

    // 解法3，中序遍历+全局变量
    public boolean isValidBST3(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 判断左子树
        if (!helper(root.left)) {
            return false;
        }

        // 判断当前节点
        if (pre != null && root.val <= pre.val) {
            return false;
        }

        //判断右子树
        pre = root;
        if (!helper(root.right)) {
            return false;
        }

        return true;
    }


}
