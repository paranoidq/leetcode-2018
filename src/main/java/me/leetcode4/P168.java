package me.leetcode4;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P168 {


    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
