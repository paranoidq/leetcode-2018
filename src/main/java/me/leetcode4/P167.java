package me.leetcode4;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P167 {


    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i + 1, j + 1};

    }
}
