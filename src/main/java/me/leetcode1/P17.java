package me.leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P17 {
    // 添加idx=0为空，避免下标转换
    private static String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() <= 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, ans);
        return ans;
    }

    public static void helper(String digits, int idx, StringBuilder sb, List<String> ans) {
        // 递归结束条件
        if (idx == digits.length()) {
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
            return;
        }
        String letters = table[Integer.parseInt(digits.substring(idx, idx + 1))];
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            sb.append(ch);
            // 递归
            helper(digits, idx + 1, sb, ans);
            // 必须还原回去
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
