package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P205 {

    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null && s.length() != t.length()) {
            return false;
        }
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }

        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (((s.charAt(i) == s.charAt(i - 1)) && t.charAt(i) != t.charAt(i - 1))
                ||
                ((s.charAt(i) != s.charAt(i - 1)) && t.charAt(i) == t.charAt(i - 1))
                ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abbf";
        String s2 = "oddd";

        boolean rst = new P205().isIsomorphic(s1, s2);
        System.out.println(rst);

    }
}
