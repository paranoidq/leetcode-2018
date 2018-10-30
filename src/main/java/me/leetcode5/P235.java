package me.leetcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P235 {

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 我的思路：
     * 在findPath中，将找到p、q的路径记录下来，然后从头开始比较，如果节点相同，就更新ancestor，直到不同或达到最后为止
     *
     * 注意：
     * 1. 节点自身也是ancestor，因此findPath中要将找到的p也加入到链表的尾部，否则会BUG
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);
        int len = path1.size() < path2.size() ? path1.size() : path2.size();
        TreeNode ancestor = root;
        for (int i = 0; i < len; i++) {
            if (path1.get(i) == path2.get(i)) {
                ancestor = path1.get(i);
            }
        }
        return ancestor;
    }

    public List<TreeNode> findPath(TreeNode root, TreeNode p) {
        List<TreeNode> path = new ArrayList<>();
        while (root != null && root != p) {
            path.add(root);
            if (p.val < root.val) {
                root = root.left;
            } else if (p.val > root.val) {
                root = root.right;
            }
        }
        if (root != null) {
            path.add(root);
        }
        return path;
    }


    /**
     * 思路2：
     *
     * 通过DFS的过程直接找，巧妙
     *
     * 如果root大于p\q的中的最大值，那么两者的最小父节点应该在root.left子树中，因为都要往左找
     * 如果root小于p\q的最小值，那么两者的最小父节点应该在root.right子树中，因为都要往右找
     * 否则的话，root就是p\q的最小父节点，因为这意味着root介于p和q中间，到root后两者就要分道扬镳了（这个理解很重要！！！）
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
