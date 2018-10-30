package me.leetcode6;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P268 {

    /**
     * 方法：
     * 1. 排序
     * 2. 求和，然后减
     * 3. hashMap
     * 4. xor操作：a^b^b = a，题目中index正好与n[i]一一对应，所以全部xor之后，剩下的就是那个missing number
     *
     * @param nums
     * @return
     */
    /*
    public int missingNumber(int[] nums) {
        int max = nums.length;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return (max + 1) * max / 2 - sum;
    }
    */
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new P268().missingNumber(nums));

    }

}
