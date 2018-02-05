package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P91 {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return ways(s);
    }

    private int ways(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if (s.length() == 2) {
            if (s.contains("0")) {
                if (s.equals("00")) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                int num = Integer.parseInt(s);
                return num <= 26 ? 2 : 1;
            }
        }
        int headNum = Integer.parseInt(s.substring(0, 2));
        return headNum <= 26 ? ways(s.substring(2)) + ways(s.substring(1)) : ways(s.substring(1));
    }



    public static void main(String[] args) {
        System.out.println(new P91().numDecodings("12"));
    }
}
