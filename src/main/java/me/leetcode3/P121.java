package me.leetcode3;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P121 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        int curMin = Integer.MAX_VALUE;
        // 遍历的过程中，保存已遍历的所有元素的最小值（buy），然后不断比较当前sell所获得的收益与保存的收益谁大
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - curMin);
            curMin = Math.min(prices[i], curMin);
        }
        return profit;
    }
}
