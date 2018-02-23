package me.leetcode4;

import java.util.Map;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P152 {

    public int maxProduct(int[] nums) {
        int r = nums[0];

        int imax = r;
        int imin = r;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            r = Math.max(r, imax);
        }
        return r;
    }


    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 有三种可能性
            // 1：最大值就是num[i]，2：最大值的到前一个数字为止统计的最大值*num[i], 3:最大值的到前一个数字为止统计的最小值*num[i]
            // 这里相当于上一个解法中的swap反转
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(min[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);

            // DP的过程中不断记录最大值
            res = Math.max(res, max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new P152().maxProduct(nums));
    }
}
