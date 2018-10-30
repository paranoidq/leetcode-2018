package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }


    public boolean isPowerOfTwo2(int n) {
        // Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
        return n > 0 && (n & (n - 1)) == 0;
    }

}
