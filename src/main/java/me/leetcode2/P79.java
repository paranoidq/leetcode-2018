package me.leetcode2;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P79 {

    // 深度搜索
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 注意，这里的visited设置不能忘记
                    visited[i][j] = true;
                    helper(i, j, board, m, n, word.substring(1), visited);
                    // 注意，这里的visited设置不能忘记
                    visited[i][j] = false;
                }
            }
        }
        return found;
    }

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};
    private boolean found = false;

    private void helper(int r, int c, char[][] board, int m, int n, String word, boolean[][] visited) {
        if (found || word.isEmpty()) {
            found = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cr = r + dr[i];
            int cc = c + dc[i];
            if (0 <= cr && cr < m && 0 <= cc && cc < n && !visited[cr][cc]
                && board[cr][cc] == word.charAt(0)) {
                visited[cr][cc] = true;
                helper(cr, cc, board, m, n, word.substring(1), visited);
                visited[cr][cc] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'C','A','A'},
            {'A','A','A'},
            {'B','C','D'}};
        System.out.println(new P79().exist(board, "AAB"));
    }
}
