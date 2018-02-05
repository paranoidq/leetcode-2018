package me.leetcode2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        if (nums == null || nums.length < 1) {
            return ans;
        }

        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    public void helper(int[] nums, int pos, List<Integer> subsets, List<List<Integer>> ans) {
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            subsets.add(nums[i]);
            ans.add(new ArrayList<>(subsets));
            // 注意，这里要写的是i+1，而不是pos+1, pos只是迭代开始的起始位置，
            // 下一层递归应该从当前迭代的位置i的下一个位置开始，而不是从起始位置的下一个位置开始
            helper(nums, i + 1, subsets, ans);
            subsets.remove(subsets.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(new P90().subsetsWithDup(nums));
    }
}
