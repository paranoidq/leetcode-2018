package me.leetcode2;

import java.util.Arrays;

/**
 *
 * http://www.cnblogs.com/ganganloveu/p/3703746.html
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P75 {

    // counting sort
    // 需要两次遍历数组
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }

    public static void sortColors1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                // 换过来的可能是1或0，因此i不自增，还需要进行判断
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void sortColors2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int l0 = -1;
        int l1 = -1;
        int l2 = -1;
        for (int i = 0; i < nums.length; i++) {
            // 平移往后挪，本质上先把最后一个2挪一个，然后把最后一个1挪一下（覆盖掉第一个2），最后把新增一个0（覆盖掉第一个1）
            // 整体结果来看，等于新增了一个0，下面的分支同理
            if (nums[i] == 0) {
                nums[++l2] = 2;
                nums[++l1] = 1;
                nums[++l0] = 0;
            } else if (nums[i] == 1) {
                nums[++l2] = 2;
                nums[++l1] = 1;
            } else {
                nums[++l2] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
