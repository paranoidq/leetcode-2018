package me.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return ans;
        }
        helper(s, 0, "", ans);
        return ans;
    }

    private static void helper(String s, int k, String chosen, List<String> ans) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4) {
                ans.add(chosen.substring(1));
            }
            return;
        }

        // 如果是0开头，那么只能取一位0；如果不是0开头，可以取1,2,3位三种，分别进行判断
        // 注意边界条件 i<= s.length() 和i <= 1 or 3中的等于号
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {    // 避免0开头的数字
            String part = s.substring(0, i);
            if (Integer.parseInt(part) <= 255) {
                // DFS递归
                helper(s.substring(i), k + 1, chosen + "." + part, ans);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
