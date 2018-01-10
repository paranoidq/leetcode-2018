package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P7 {

    public static int reverse(int x) {
        long ans = 0;
        int y = Math.abs(x);
        while (y > 0) {
            ans = ans * 10 +  y%10;
            if (ans > Integer.MAX_VALUE) {
                return 0;
            }
            y /= 10;
        }
        return (int) (x > 0 ? ans: -ans);
    }


    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
