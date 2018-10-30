package me.leetcode4;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P189 {

    // 最笨的办法
    public void rotate1(int[] nums, int k) {
        int[] rotate = new int[nums.length];
        k = k % nums.length;

        int sep = nums.length - k;
        // 偏移的k个元素
        for (int i = 0; i < k; i++) {
            rotate[i] = nums[i + sep];
        }

        // 余下的n-k个元素
        for (int i = 0; i < nums.length - k; i++) {
            rotate[k + i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotate[i];
        }
    }


    // 三次旋转
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 这一步可以不用，swap能处理，但是可以加上用于直接返回从而提升效率
        if (k == 0) {
            return;
        }
        int partition = nums.length - k;

        swap(nums, 0, partition - 1);
        swap(nums, partition, nums.length - 1);
        swap(nums, 0, nums.length - 1);

    }


    private void swap(int[] nums, int l, int r) {
        while (l <= r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }




    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        new P189().rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }
}
