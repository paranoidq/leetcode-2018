package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }


    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        return divide(strs, 0, strs.length - 1);
    }

    public static String divide(String[] strs, int l, int r) {
        if (l == r) {
            // 同一个string的最长公共前缀就是本身
            return strs[l];
        }
        int mid = (l + r) / 2;
        String leftCommon = divide(strs, l, mid);
        String rightCommon = divide(strs, mid + 1, r);
        return conquer(leftCommon, rightCommon);
    }

    public static String conquer(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        for (int i = 0; i < minLen; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLen);
    }

    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        int l = 1;
        int h = minLen;
        // 如果少了等于号，错误的case：
        // ["a", "b"] 会输出"a", 正确结果: ""
        // l==r的时候也要算，否则会遗漏str[0].charAt(l)这个字符，因为l表示的左半部分的右边界（不包含）
        while (l <= h) {
            int mid = (l + h) / 2;
            if (isCommonPrefix(strs, mid)) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return strs[0].substring(0, (l + h) / 2);
    }
    public static boolean isCommonPrefix(String[] strs, int minLen) {
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (j == strs.length || ch != strs[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = {
            "b",
            "a",
        };
        System.out.println(longestCommonPrefix4(strs));

    }
}
