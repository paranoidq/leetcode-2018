package me.leetcode;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P16 {

    /**
     * 注意比较的到底是什么和下标细节处理！！！！
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Input array has less then 3 nums");
        }

        int ans = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int c = nums[i];
            int targetX = target - c;
            int sumCloset = twoSumCloset(nums, i + 1, nums.length - 1, targetX);

            // 比较的是距离target的差值
            if (Math.abs(ans - target) > Math.abs(sumCloset + c - target)) {
                ans = sumCloset + c;
            }
        }
        return ans;
    }

    /**
     * 返回的是距离target最近的值
     * @param nums
     * @param l
     * @param r
     * @param target
     * @return
     */
    public static int twoSumCloset(int[] nums, int l, int r, int target) {
        int ans = nums[l] + nums[r];
        while (l < r) {
            if (target == nums[l] + nums[r]) {
                // 这里要返回target，不能返回0，返回的是值，不是差值！！！！
                return target;
            } else if (nums[l] + nums[r] < target) {
                if (Math.abs(ans - target) > Math.abs(nums[l] + nums[r] - target)) {
                    ans = nums[l] + nums[r];
                }
                l++;
            } else {
                if (Math.abs(ans - target) > Math.abs(nums[l] + nums[r] - target)) {
                    ans = nums[l] + nums[r];
                }
                r--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(nums, 3));

    }
}
