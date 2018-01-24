package me.leetcode2;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P64 {


    /**
     * 题目没有要求不能改变原始数组
     *
     *
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 注意，这里第0行和第0列，初始化方式与Unique Path题不一样，这里需要累加
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1}, {1,5,1}, {4,2,1}
        };
        System.out.println(minPathSum(grid));

    }


}
