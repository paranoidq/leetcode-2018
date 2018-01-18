package me.leetcode;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P35 {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("array is not initialized");
        }
        if (nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int target =3;
        System.out.println(searchInsert(nums, target));

    }
}
