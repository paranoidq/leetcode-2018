package me.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return ans;
        }

        List<Integer> rst = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, rst, ans);
        return ans;
    }

    private static void helper(int[] candidates, int pos, int gap, List<Integer> res, List<List<Integer>> ans) {
        if (gap <= 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            // 当前的candidate[i]已经大于gap，无法加起来等于target了，故return
            if (gap < candidates[i]) {
                return;
            }
            // for循环属于同一层级的递归，因此需要避免同一层级的递归选择了两次相同的数
            // 而[1,1,6]这里的两个1在递归时不是同一个递归层级的，所以可以出现
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            res.add(candidates[i]);
            helper(candidates, i + 1, gap - candidates[i], res, ans);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(nums, target));
        System.out.println(Arrays.toString(nums));

    }
}
