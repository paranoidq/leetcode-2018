package me.leetcode2;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P66 {

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int[] ans = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            carry = val > 9 ? 1 : 0;
            val = val % 10;
            ans[i] = val;
        }
        if (carry != 0) {
            int[] tmp = ans;
            ans = new int[ans.length + 1];
            System.arraycopy(tmp, 0, ans, 1, tmp.length);
            ans[0] = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }
}
