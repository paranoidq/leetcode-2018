package me.leetcode3;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P122 {

    // 可以买卖多次
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        int buy = 0;
        boolean flag = true;
        // 每个局部波峰波谷都进行一次交易，这时整体profit最优, 如何证明？？？？
        for (int i = 1; i < prices.length; i++) {
            if (flag) {
                // 找到局部波谷，然后开始buy
                if (prices[i] < prices[i - 1]) {
                    continue;
                } else {
                    buy = prices[i - 1];
                    flag = !flag;
                }
            } else {
                // 找到局部波峰，sell
                if (prices[i] > prices[i - 1]) {
                    continue;
                } else {
                    profit += (prices[i - 1] - buy);
                    flag = !flag;
                }
            }
        }
        return profit;
    }


    // 无需找到所有的波谷波峰，而只需要计算相邻元素的差值，如果差值大于0，就加和即可
    // 因为要找的是单调递增区间，那么这个区间的总profit与相邻元素的差值的加和是等价的
    // 这样就避免了很多麻烦
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

}
