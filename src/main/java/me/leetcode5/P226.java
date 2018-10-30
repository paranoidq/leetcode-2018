package me.leetcode5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P226 {


    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 这里的问题在于，下一行的root.left指针已经变了，所以错了，指针需要提前保存一下
//        root.left = invertTree(root.right);
//        root.right = invertTree(root.left);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode left = p.left;
            p.left = p.right;
            p.right = left;

            if (p.left != null) {
                stack.push(p.left);
            }

            if (p.right != null) {
                stack.push(p.right);
            }
        }
        return root;
    }


    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();

            TreeNode left = p.left;
            p.left = p.right;
            p.right = left;

            if (p.left != null) {
                queue.add(p.left);
            }

            if (p.right != null) {
                queue.add(p.right);
            }
        }

        return root;


    }


}
