package me.leetcode2;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                } else {
                    if (i == m - 1 && j == n - 1) {
                        memo[i][j] = 1;
                    } else {
                        int p1 = i + 1 == m ? 0 : memo[i + 1][j];
                        int p2 = j + 1 == n ? 0 : memo[i][j + 1];
                        memo[i][j] = p1 + p2;
                    }
                }
            }
        }

        for (int i = 0; i < memo.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }

        return memo[0][0];
    }


    public static void main(String[] args) {
        int[][] grid = new int[1][1];
        grid[0][0] = 0;
        uniquePathsWithObstacles(grid);
    }
}
