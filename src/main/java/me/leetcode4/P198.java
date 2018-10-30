package me.leetcode4;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P198 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int val = nums[i];
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + val);
        }
        return memo[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = prev1;        // 需要先保留prev1，是下一轮的prev2
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rst = new P198().rob2(nums);
        System.out.println(rst);

    }
}
