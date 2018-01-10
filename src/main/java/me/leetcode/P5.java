package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P5 {

    public static String longestPalindrome(String s) {
        int n = s.length();
        // 奇数
        String ans = "";
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; i - j >= 0 && i + j < n && s.charAt(i-j) == s.charAt(i+j); j++) {
            }
            String palindrome = s.substring(i - j + 1, i + j);
            ans = ans.length() < palindrome.length() ? palindrome : ans;
        }

        // 偶数
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            int j = 0;
            for (; i - j >= 0 && i + 1 + j < n && s.charAt(i-j) == s.charAt(i+1+j); j++) {
            }
            String palindrome = s.substring(i - j + 1, i + 1 + j);
            ans = ans.length() < palindrome.length() ? palindrome : ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
