package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P33 {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                l = i + 1;
            }
        }

        int h = l + nums.length - 1;
        while (l <= h) {
            int mid = ((l + h) / 2 ) % nums.length;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l++;
            } else {
                h--;
            }
        }
        return -1;
    }


    /**
     * 看成两段有序数组，前一段数组的都大于第二段数组
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            // 此时l - mid 必然有序，证明mid落在前半段有序数组内
            if (nums[mid] == target) {
                return mid;
            }

            // 边界条件
            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    // case1: target在l - mid内 （此区间有序）
                    h = mid - 1;
                } else {
                    // case2: target在mid - h内
                    l = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int target = 1;
        int[] nums = {3, 1};
        System.out.println(search2(nums, target));
    }
}
