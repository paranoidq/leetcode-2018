package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P28 {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() < needle.length()
            || needle == null) {
            return -1;
        }
        if (needle.length() <= 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        System.out.println(strStr(haystack, needle));
    }
}
