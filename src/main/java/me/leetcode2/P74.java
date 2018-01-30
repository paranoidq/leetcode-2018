package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null
            || matrix.length <= 0
            || matrix[0].length <= 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = m - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int rowSmallest = matrix[mid][0];
            int rowLargest = matrix[mid][n - 1];
            if (rowSmallest > target) {
                j = mid - 1;
            } else if (rowLargest < target) {
                i = mid + 1;
            } else {
                i = mid;
                break;
            }
        }
        int[] cr = matrix[i];
        if (!(cr[0] <= target && target <= cr[n - 1])) {
            return false;
        }
        i = 0;
        j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (cr[mid] == target) {
                return true;
            } else if (cr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return cr[i] == target;

    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 4, 5},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 1));

    }
}
