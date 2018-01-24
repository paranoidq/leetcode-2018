package me.leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P1 {
    private static final int[] nums = {3,2,4};
    private static final int target = 6;


    public int[] twoSum(int[] nums, int target) {
        int a = -1;
        int b = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a = i;
                    b = j;
                    return new int[]{a, b};
                }
            }
        }
        return new int[]{a, b};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum exception");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)
                && map.get(complement) != i) { // 避免重复使用两次同一个元素
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum exception");
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1().twoSum(nums, target)));
    }
}
