package me.leetcode2;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P62 {

    // 超时
    public int uniquePaths(int m, int n) {
        return recursive(0, 0, m, n);
    }

    private int recursive(int i, int j, int m, int n) {
        // 异常判断
        if (m < 1 || n < 1) {
            return 0;
        }


        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if ((i == m - 1 && j == n - 2) || (i == m - 2 && j == n - 1)) {
            return 1;
        }
        if (i < m - 1 && j < n - 1) {
            return recursive(i + 1, j, m, n) + recursive(i, j + 1, m, n);
        } else if (i == m - 1 && j < n - 1) {
            return recursive(i, j + 1, m, n);
        } else {
            return recursive(i + 1, j, m, n);
        }
    }


    // 动态规划的典型案例！！！！！
    public static int uniquePaths1(int m, int n) {
        // 异常判断
        if (m < 1 || n < 1) {
            return 0;
        }

        int[][] memo = new int[m][n];
        Arrays.fill(memo[m - 1], 1);
        for (int i = 0; i < m; i++) {
            memo[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
            }
        }

        for (int i = 0; i < memo.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        uniquePaths1(3,3);
    }

    private static void print(int[][] matrix) {

    }
}
