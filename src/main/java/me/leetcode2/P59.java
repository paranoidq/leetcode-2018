package me.leetcode2;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P59 {

    public static int[][] generateMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("invalid n");
        }

        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            ans[i] = new int[n];
            Arrays.fill(ans[i], 0);
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int di = 0;
        int r = 0;
        int c = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[r][c] = i;

            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr <= n - 1 &&
                0 <= cc && cc <= n - 1 &&
                ans[cr][cc] == 0) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        print(generateMatrix(1));
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
