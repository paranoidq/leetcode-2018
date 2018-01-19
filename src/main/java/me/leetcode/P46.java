package me.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }

        List<Integer> choosen = new ArrayList<>();
        helper(nums, ans, choosen);
        return ans;
    }

    private static void helper(int[] nums, List<List<Integer>> ans, List<Integer> choosen) {
        if (choosen.size() == nums.length) {
            ans.add(new ArrayList<>(choosen));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!choosen.contains(nums[i])) {
                choosen.add(nums[i]);
                helper(nums, ans, choosen);
                choosen.remove(choosen.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));

    }
}
