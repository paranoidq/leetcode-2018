package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P11 {

    /**
     * 1. 双指针
     * 2. 理解如何移动指针：移动长线的指针是无效的，因为最大面积只取决于短线的指针。因此每次比较，向中间移动短线的指针
     * Initially we consider the area constituting the exterior most lines.
     * Now, to maximize the area, we need to consider the area between the lines of larger lengths.
     * If we try to move the pointer at the longer line inwards, we won't gain any increase in area,
     * since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial,
     * as per the same argument, despite the reduction in the width.
     * This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction
     * in area caused by the width reduction.
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
