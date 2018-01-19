package me.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 该题与40题不同的地方在于：
 *  1. 允许重复多次选择一个数字
 *  2. candidates中没有重复的数字，如果有的话，该如何处理去重的问题？？？？？
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P39 {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (gap == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            // 当前的candidate[i]已经大于gap，无法加起来等于target了，故return
            if (gap < candidates[i]) {
                return;
            }
            res.add(candidates[i]);
            // 这里可以多次使用一个元素，因此i不增加
            helper(candidates, i, gap - candidates[i], res, ans);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
        System.out.println(Arrays.toString(nums));

    }
}
