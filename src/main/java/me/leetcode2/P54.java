package me.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return ans;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];


        // 学习这种表示方向的方式！！！！
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0, di = 0;
        for (int i = 0; i < n * m; i++) {
            ans.add(matrix[r][c]);
            visited[r][c] = true;

            int cr = r + dr[di];
            int cc = c + dc[di];

            if (0 <= cr && cr < n && 0 <= cc && cc < m
                && !visited[cr][cc]) {
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

    }
}
