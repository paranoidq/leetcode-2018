package me.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length < 1) {
            return ans;
        }
        helper(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private static void helper(int[] nums, int pos, List<Integer> subsets, List<List<Integer>> ans) {
        if (pos == nums.length) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            subsets.add(nums[i]);
            ans.add(new ArrayList<>(subsets));
            helper(nums, i + 1, subsets, ans);
            subsets.remove(subsets.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
