package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P73 {


    public static void setZeroes(int[][] matrix) {
        if (matrix == null
            || matrix.length <= 0
            || matrix[0].length <= 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean col0Zero = false;
        boolean row0Zero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0Zero = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row0Zero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0Zero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0Zero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {

    }
}
