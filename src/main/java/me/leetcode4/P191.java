package me.leetcode4;

/**
 * ??
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P191 {

    public int hammingWeight(int n) {
        long un = Integer.toUnsignedLong(n);
        int c = 0;
        while (un > 0) {
            un &= un - 1;
            c++;
        }
        return c;
    }


    public static void main(String[] args) {

    }
}
