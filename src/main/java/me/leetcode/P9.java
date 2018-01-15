package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P9 {

    /**
     * 有错，没有判断负数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int reverse = 0;
        int n = x;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }
        return reverse == x;
    }

    /**
     * 更好的写法：需要注意边界条件判断
     * 1 首先判断是否是负数或10的非0倍数，负数直接返回false
     * 2 然后通过while循环找到后半个half number的数值
     * 3 判断后半个half等于前半个half
     *
     * 时间复杂度为log10(n)，空间复杂度为O(1)
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedHalf = 0;
        while (x > revertedHalf) {
            revertedHalf = revertedHalf * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return (x == revertedHalf || x == revertedHalf / 10);
    }




    public static void main(String[] args) {
        int n = 101;
        System.out.println(isPalindrome(n));
    }

}
