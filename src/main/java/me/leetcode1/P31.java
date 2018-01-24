package me.leetcode1;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P31 {

    public static void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            Arrays.sort(nums);
            return;
        }

        int l = -1;
        for (int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }

        // swap
        int tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;

        // reverse k+1 - n-1
        for (int lo = k + 1, hi = nums.length - 1; lo < hi; lo++, hi--) {
            tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
