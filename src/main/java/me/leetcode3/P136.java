package me.leetcode3;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P136 {


    // 技巧：使用异或操作
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}
