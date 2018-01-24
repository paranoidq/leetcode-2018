package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P50 {

    public static double myPow(double x, int n) {
        if (n < 0) {
            // 必须这么处理x，否则有如果先算结果，然后再用1除的话，有可能越界！！！！
            x = 1 / x;
            n = -n;
        }
        double ans = helper(x, n);
        return ans;
    }

    private static double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public static double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1;
        double product = x;
        for (int i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans *= product;
            }
            product = product * product;
        }
        return ans;
    }



    public static void main(String[] args) {
        double x = 1;
        int n = -3;
        System.out.println(myPow(x, n));
    }
}
