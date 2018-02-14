package me.leetcode3;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P131 {


    // TLE
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return ans;
        }

        int maxParts = s.length();
        for (int i = 1; i <= maxParts; i++) {
            helper(s, new ArrayList<>(), ans, i);
        }
        return ans;
    }

    public void helper(String s, List<String> parts, List<List<String>> ans, int numParts) {
        if (s.isEmpty() && numParts == 0) {
            ans.add(new ArrayList<>(parts));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (isPalindrome(part)) {
                parts.add(part);
                helper(s.substring(i, s.length()), parts, ans, numParts - 1);
                parts.remove(parts.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    /**
     * 换一种写法
     * @param s
     * @return
     */
    public List<List<String>> partition2(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return ans;
        }
        helper(s, ans, new ArrayList<String>());
        return ans;
    }

    private void helper(String s, List<List<String>> ans, List<String> curList) {
        if (curList.size() > 0 && s.isEmpty()) {
            ans.add(new ArrayList<>(curList));
        }
        for (int i = 1; i <= s.length(); i++) {
            // 先取第一个是回文的子串，然后递归调用切分余下的串为回文
            String firstPart = s.substring(0, i);
            if (isPalindrome(firstPart)) {
                curList.add(firstPart);
                helper(s.substring(i), ans, curList);
                // 递归调用完成后，移除盖层递归调用的最后一个子串
                curList.remove(curList.size() - 1);
            }
        }
    }




    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(new P131().partition2(s));
    }
}
