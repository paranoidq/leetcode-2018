package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums1.length < 1 || n < 1) {
            return;
        }
        if (m < 1) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        // 从后往前遍历，可以避免swap
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        // 注意，这里只需要检查j是否有剩余，如果i有剩余，那么不用拷贝了，直接就是nums1的剩下的部分
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

}
