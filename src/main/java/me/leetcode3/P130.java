package me.leetcode3;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P130 {

    public void solve(char[][] board) {

    }


    private void check(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;

        board[i][j] = '1';
        if (i > 0) {
            check(board, i, j);
        }
    }
}
