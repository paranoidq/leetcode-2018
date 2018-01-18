package me.leetcode;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P36 {
    private static boolean[] used = new boolean[10];

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length <= 0) {
            return false;
        }

        //check row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++) {
                if (isDuplicate(board[i][j], used)) {
                    return false;
                }
            }
        }

        // check coloum
        for (int i = 0; i < 9; i++) {
            Arrays.fill(used, false);
            for (int j = 0; j < 9; j++) {
                if (isDuplicate(board[j][i], used)) {
                    return false;
                }
            }
        }

        // check box
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidBox(board, i, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidBox(char[][] board, int x, int y) {
        boolean[] numUsed = new boolean[9];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (isDuplicate(board[i][j], numUsed)) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isDuplicate(char c, boolean[] used) {
        if (c == '.') {
            return false;
        }
        if (used[c - '1']) {
            return true;
        } else {
            used[c - '1'] = true;
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {1,'2','3','.',5}
        };
        System.out.println(isValidSudoku(board));
    }


}
