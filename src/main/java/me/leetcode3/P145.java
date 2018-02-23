package me.leetcode3;

import me.TreeNode;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P145 {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        helper(root.left, ans);
        helper(root.right, ans);
        ans.add(root.val);
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            if (p.right != null && pre != p.right) {
                stack.push(p);
                p = p.right;
            } else {
                ans.add(p.val);
                pre = p;
                p = null;
            }
        }
        return ans;
    }


}
