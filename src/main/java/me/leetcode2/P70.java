package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P70 {

    // TLE
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 动态规划
     * 费布拉奇数列
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ans = 0;
        int a = 1;
        int b = 2;
        while (n > 2) {
            ans = a + b;
            a = b;
            b = ans;
            n--;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
