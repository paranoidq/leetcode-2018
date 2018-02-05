package me.leetcode2;

import me.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        visit(root, ans);
        return ans;
    }

    public static void visit(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        visit(root.left, ans);
        ans.add(root.val);
        visit(root.right, ans);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 一直访问左子树，并保存当前节点，直到没有左子树了
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            // 访问当前节点
            cur = stack.pop();
            ans.add(cur.val);

            // 定位到当前节点的右子树，继续上面的逻辑
            cur = cur.right;
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        root.right = p1;
        p1.left = p2;
        System.out.println(inorderTraversal2(root));

    }

}
