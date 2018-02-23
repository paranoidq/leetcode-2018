package me.leetcode3;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P134 {


    // Not correct
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int maxIdx = -1;
        int maxReserved = Integer.MIN_VALUE;

        /*
          这里的思路有问题，选择最大的reserved作为起始点是不正确的，与max sum的思路应该是一致的，需要从头开始统计
         */
        int[] reserve = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            reserve[i] = gas[i] - cost[i];

            // find max reserve station, and set is as start station
            if (reserve[i] > maxReserved) {
                maxIdx = i;
                maxReserved = reserve[i];
            }
        }

        // check if can complete journey
        int sum = 0;
        for (int i = maxIdx; i < maxIdx + reserve.length; i++) {
            sum += reserve[i % reserve.length];
            if (sum < 0) {
                return -1;
            }
        }
        return maxIdx;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0) {
            return -1;
        }

        int start = 0;
        int accumulate = 0;
        for (int i = 0; i < gas.length; i++) {
            int reserved = gas[i] - cost[i];
            if (accumulate + reserved < 0) {
                start = i + 1;
                accumulate = 0;
            } else {
                accumulate += reserved;
            }
        }
        return start;
    }
}
