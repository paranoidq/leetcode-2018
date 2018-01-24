package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P53 {

    /**
     * 本质上是动态规划法：http://blog.csdn.net/linhuanmars/article/details/21314059
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }


    /**
     * 分治法
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (l == r - 1) {
            return Math.max(nums[l] + nums[r], Math.max(nums[l], nums[r]));
        }

        int mid = l + (r - l) / 2;
        int leftMax = helper(nums, l, mid - 1);
        int rightMax = helper(nums, mid + 1, r);

        int midMax = nums[mid];
        int tmp = midMax;
        for (int i = mid - 1; i >= l; i--) {
            tmp += nums[i];
            midMax = Math.max(tmp, midMax);
        }
        tmp = midMax;
        for (int i = mid + 1; i <= r; i++) {
            tmp += nums[i];
            midMax = Math.max(tmp, midMax);
        }

        return Math.max(Math.max(leftMax, rightMax), midMax);
    }


    /**
     * 动态规划法
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        int global = nums[0];
        int local = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], nums[i] + local);
            global = Math.max(global, local);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(nums));
    }
}
