package me.leetcode2;

import me.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P95 {

    public static List<TreeNode> generateTrees(int n) {
        // 需要加上这一段边界case，否则过不了
        if (n < 1) {
            return Collections.emptyList();
        }
        return helper(1, n);
    }

    private static List<TreeNode> helper(int s, int e) {
        List<TreeNode> ans = new ArrayList<>();

        if (e < s) {
            ans.add(null);
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftPossibles= helper(s, i - 1);
            List<TreeNode> rightPossibles = helper(i + 1, e);
            for (TreeNode left : leftPossibles) {
                for (TreeNode right : rightPossibles) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = left;
                    curRoot.right = right;
                    ans.add(curRoot);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3).size());
    }
}
