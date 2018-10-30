package me.leetcode6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P257 {

    static public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        String path = "";
        // 必须要处理null的情况
        if (root != null) {
            traverse(root, path, rst);
        }
        return rst;
    }

    /**
     * 1. 递归的结束条件：left和right都为null，这是可以输出到结果集了
     * 2. 这里利用了String的不变性，如果用StringBuilder，left递归完了之后要pop一下
     *
     * @param root
     * @param path
     * @param rst
     */
    public void traverse(TreeNode root, String path, List<String> rst) {
        if (root.left == null && root.right == null) {
            rst.add(path + root.val);
        }

        if (root.left != null) {
            traverse(root.left, path + root.val + "->", rst);
        }
        if (root.right != null) {
            traverse(root.right, path + root.val + "->", rst);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        List<String> rst = new P257().binaryTreePaths(node1);
        System.out.println(rst);
    }
}
