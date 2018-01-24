package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P48 {

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        int n = matrix.length;
        // 左右对调
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int p = n - 1 - j;
                if (j < p) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][p];
                    matrix[i][p] = tmp;
                }
            }
        }

        // 斜线对调
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int p = n - 1 - j;
                int q = n - 1 - i;
                if (matrix[i][j] == matrix[p][q]) {
                    continue;
                }
                // 注意此处的判断条件，否则交换过去的还会被交换回来
                if (p > i) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[p][q];
                    matrix[p][q] = tmp;
                }
            }
        }
    }

}
