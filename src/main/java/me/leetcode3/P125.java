package me.leetcode3;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        // 坑2：包括字母和数字
        String alphas = "0123456789abcdefghijklmnopqrstuvwxyz";
        // 坑1：忽略大小写
        char[] chs = s.toLowerCase().toCharArray();

        int i = 0, j = chs.length - 1;
        while (i < j) {
            char left = chs[i];
            char right = chs[j];

            if (alphas.indexOf(left) == -1) {
                i++;
                continue;
            }
            if (alphas.indexOf(right) == -1) {
                j--;
                continue;
            }
            if (left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = ",M 9y\"yj\"j9 M,";
        System.out.println(new P125().isPalindrome(s));
    }
}
