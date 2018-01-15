package me.leetcode;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P26 {


    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("nums is empty");
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 1;
        int j = i + 1;  // 不要回退j，否则时间复杂度为o(n2)
        for (; i < nums.length; ) {
            if (nums[i] <= nums[i - 1]) {
                boolean end = true;
                while (j < nums.length){
                    if (nums[j] > nums[i]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        end = false;
                        j++;
                        break;
                    } else {
                        j++;
                    }
                }
                // 必须检查结束条件，否则会造成无限循环
                if (end) {
                    return i;
                }
            } else {
                i++;
            }
        }
        return i;
    }


    /**
     * 1. 直接覆盖即可，不用swap增加繁琐
     * 2. i表示当前已经检查过的没有重复项的maxIdx，因此发现下一个不重复的项时，先++再覆盖
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,5};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }
}
