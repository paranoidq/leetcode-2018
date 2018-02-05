package me.leetcode3;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        if (rowIndex < 0) {
            return ans;
        }
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.add(1);
            // 注意，这里需要从后往前进行遍历，否则会在遍历的过程中会覆盖上一层的值
            for (int j = ans.size() - 2; j >= 1; j--) {
                ans.set(j, ans.get(j - 1) + ans.get(j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P119().getRow(4));
    }
}
