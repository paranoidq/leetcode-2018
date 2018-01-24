package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P58 {
    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        for (; i >= 0; i--) {
            if (chars[i] != ' ') {
                break;
            }
        }
        int count = 0;
        for (int j = i; j >=0 ; j--) {
            if (chars[j] != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int begin = 0, end = s.length() - 1;

        // trim right space
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        // find the last space
        for (int i = 0; i <= end; i++) {
            if (s.charAt(i) == ' ') {
                begin = i + 1;
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        String s = "    ";
        System.out.println(lengthOfLastWord(s));
    }
}
