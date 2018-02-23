package me.leetcode4;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P171 {

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
