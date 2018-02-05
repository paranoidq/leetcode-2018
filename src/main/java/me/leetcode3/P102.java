package me.leetcode3;

import me.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> line;
        while (!q.isEmpty()) {
            line = new ArrayList<>();

            // 首先保存每层的节点数目，即队列的大小，因为后续的入队和出队会导致队列长度变化
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
        return ans;
    }
}
