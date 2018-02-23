package me.leetcode3;

import me.TreeNode;
import me.leetcode1.P14;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P144 {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }


    /**
     * 非递归解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        // 边界条件
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;

        System.out.println(new P144().preorderTraversal2(n1));

    }
}
