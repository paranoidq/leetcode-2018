package me.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何改为迭代的形式？？？
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P77 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        if (k > n) {
            throw new IllegalArgumentException("error k > n");
        }
        helper(0, new ArrayList<Integer>(), n, ans, k);
        return ans;
    }

    private static void helper(int i, List<Integer> combination, int n, List<List<Integer>> ans, int k) {
        if (combination.size() == k) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        for (int j = i + 1; j <= n; j++) {
            combination.add(j);
            helper(j, combination, n, ans, k);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));

    }
}
