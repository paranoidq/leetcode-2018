package me.leetcode3;

import me.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList<>(path));
            // 坑：不要忘记，满足条件之后return之前也应该移出最后一个元素，从而为下一次迭代做准备
            // 或者：这里不单独remove，也不要return，到函数末尾统一remove
            // 总之，无论是否满足sum，都要保证函数结束之后，应该remove掉当前递归的元素！！！！
            path.remove(path.size() - 1);
            return;
        } else {
            helper(root.left, sum - root.val, path, ans);
            helper(root.right, sum - root.val, path, ans);
        }
        path.remove(path.size() - 1);
    }
}
