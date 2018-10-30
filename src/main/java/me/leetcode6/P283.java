package me.leetcode6;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P283 {

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 将非0的元素往前插入，insertPos表示插入的位置
        int insertPos = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[insertPos++] = n;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

    }


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 交换法，j表示待插入的位置，通过i不断地找到一个非0的数，进行交换即可
        // 本质上与上面解法是一致的
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(i, j, nums);
                j++;
            }
        }
    }


    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new P283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
