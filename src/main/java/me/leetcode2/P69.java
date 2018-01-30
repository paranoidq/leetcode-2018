package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P69 {

    /**
     * TLE
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("sqrt argument is negative");
        }
        if (x <= 1) {
            return x;
        }

        int n = x / 2;
        int distance = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (square <= x && Math.abs(square - x) < distance) {
                distance = Math.abs(square - x);
                ans = i;
            } else if (square > x) {
                break;
            }
        }
        return ans;
    }


    /**
     * ERROR 不对
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("sqrt argument is negative");
        }
        if (x <= 1) {
            return x;
        }
        int f = 1;
        int b = x;

        // 注意：类似问题中，如果二分后取值是mid，而不是mid+1，则必须在f +1 < b的时候就停止，不能等到相邻
        while (f + 1 < b) {
            int mid = f + (b - f) / 2;
            // 会越界
            long square = mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                b = mid;
            } else {
                f = mid;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt1(x));
    }
}
