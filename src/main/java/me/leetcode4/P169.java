package me.leetcode4;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
