package me.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) {
            return ans;
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);
        ans.add(row);
        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = ans.get(ans.size() - 1);
            row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                row.add(pre.get(j) + pre.get(j + 1));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(new P118().generate(numRows));

    }
}
