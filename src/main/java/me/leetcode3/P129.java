package me.leetcode3;

import me.TreeNode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, new StringBuilder());
        return sum;
    }

    private int sum = 0;
    // DFS
    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
        } else {
            if (root.left != null) {
                helper(root.left, sb);
            }
            if (root.right != null) {
                helper(root.right, sb);
            }
        }

        // for next recursion
        sb.delete(sb.length() - 1, sb.length());
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        System.out.println(new P129().sumNumbers(treeNode));
    }

}
