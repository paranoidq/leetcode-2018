package me.leetcode3;

import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0 || triangle.get(0).size() <= 0) {
            return 0;
        }
        int rows = triangle.size();
        int[] minpath = new int[rows];
        // 注意，总共的行数为rows，最后一行的行号为rows-1，layer行的元素个数为layer个
        for (int i = 0; i <= rows - 1; i++) {
            minpath[i] = triangle.get(rows - 1).get(i);
        }

        for (int layer = rows - 2; layer >= 0; layer--) {
            // 因为k层算完之后，k+1层实际上已经没有用了，所以只需要用一维数组存储，每次从下层往上覆盖即可
            int layerNums = layer;
            for (int i = 0; i <= layerNums; i++) {
                minpath[i] = Math.min(minpath[i], minpath[i + 1]) + triangle.get(layer).get(i);
            }
        }
        return minpath[0];
    }
}
