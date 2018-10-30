package me.leetcode5;

import java.util.*;

/**
 * 这一题与P235的区别在于：不再是BST了，而是普通的二叉树，因此必须遍历二叉树的节点才行
 * 所以P235那种简洁的通过对比数值的思路行不通了，而必须使用findPath这种通用的思路
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P236 {

    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);

        int len = Math.min(path1.size(), path2.size());
        TreeNode ancestor = root;
        for (int i = 0; i < len; i++) {
            if (path1.get(i) == path2.get(i)) {
                ancestor = path1.get(i);
            }
        }
        return ancestor;
    }


    public List<TreeNode> findPath(TreeNode root, TreeNode p) {
        Deque<TreeNode> deque = new LinkedList<>();
        find(root, p, deque);

        List<TreeNode> path = new ArrayList<>();
        while (!deque.isEmpty()) {
            path.add(deque.removeFirst());
        }
        return path;
    }

    public boolean find(TreeNode root, TreeNode p, Deque<TreeNode> stack) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            stack.add(p);
            return true;
        } else {
            stack.add(root.left);
            boolean found = find(root.left, p, stack);
            if (!found) {
                stack.removeLast();
                stack.add(root.right);
                return find(root.right, p, stack);
            } else {
                return true;
            }
        }
    }


    /**
     * 迭代法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 记录每个节点的parent
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        // DFS遍历一遍，直到找到了q和p为止
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // 找到p的所有ancestors，包括p
        Set<TreeNode> ancestorsForP = new HashSet<>();
        while (p != null) {
            ancestorsForP.add(p);
            p = parent.get(p);
        }

        // 然后按照q的parent依次往上查找
        while (!ancestorsForP.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }


    /**
     * 递归法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
