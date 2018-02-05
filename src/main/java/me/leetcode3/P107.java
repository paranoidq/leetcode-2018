package me.leetcode3;

import me.TreeNode;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> line;
        while (!q.isEmpty()) {
            line = new ArrayList<>();
            int lineNum = q.size();
            for (int i = 0; i < lineNum; i++) {
                TreeNode t = q.poll();
                line.add(t.val);

                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }

            ans.add(line);
        }
        Collections.reverse(ans);
        return ans;
    }
}
