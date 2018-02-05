package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P96 {

    public static int numTrees(int n) {
        return helper(1, n);
    }

    // TLE
    private static int helper(int s, int e) {
        if (s > e) {
            return 1;
        }
        if (s == e) {
            return 1;
        }
        int ans = 0;
        for (int i = s; i <= e; i++) {
            ans += (helper(s, i-1) * helper(i+1, e));
        }
        return ans;
    }

    // DP：递推表达式
    public static int numTrees2(int n) {
        int[] g = new int[n + 1];
        g[0] = g[1] = 1;
        for (int i = 2; i <= n; i++) {
            int gi = 0;
            for (int j = 1; j <= i; j++) {
                gi += g[j - 1] * g[i - j];
            }
            g[i] = gi;
        }
        return g[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
