package me.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }
        if (nums.length == 1) {
            ans.add(Arrays.asList(nums[0]));
            return ans;
        }
        Arrays.sort(nums);
        List<Integer> choosen = new ArrayList<>();
        helper(nums, ans, choosen, new boolean[nums.length]);
        return ans;
    }


    private static void helper(int[] nums, List<List<Integer>> ans, List<Integer> choosen, boolean[] used) {
        if (choosen.size() == nums.length) {
            ans.add(new ArrayList<>(choosen));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
                // 此处判重的条件：
                /**
                 * i > 0
                 * 且等于前一个数，但是前一个数没有被使用的情况下，此时，该数应该是作为递归的第一层，
                 * 作为递归的第一层，显然不应该与前一个数相同，否则就重复计算了一次
                 *
                 * 也就是前一个相同的数在已经被使用的情况下，允许该数也加入candidate，否则该数作为这一层的迭代的第一个数这种情况肯定已经在前面算过了
                 */
            } else if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            } else {
                choosen.add(nums[i]);
                used[i] = true;
                helper(nums, ans, choosen, used);
                choosen.remove(choosen.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(permuteUnique(nums));

    }
}
