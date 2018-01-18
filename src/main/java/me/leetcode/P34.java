package me.leetcode;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return range;
        }

        int leftMostIndex = findIndex(nums, target, true);

        /**
         * 为什么这里需要检测边界：
         * [2,2] target=3，此时返回值会超过边界
         */
        if (leftMostIndex >= nums.length || nums[leftMostIndex] != target) {
            return range;
        }

        /**
         * 为什么这里不需要检测边界：
         * 因为如果上面没有找到target，已经返回了，所以运行到这里一定是已经找到target了
         * 因为findIndex中返回的是l，而l >= num.length的情况已经被上面排除了
         */
        int rightMostIndex = findIndex(nums, target, false);
        range[0] = leftMostIndex;
        range[1] = rightMostIndex;
        return range;
    }

    /**
     * 基本逻辑
     *
     * 找到了target之后继续向左、向右找到leftMostIndex和rightMostIndex
     *
     * 以leftMostIndex为例，此时a[l]<=target，而a[r<-mid]<=target，正常情况下，会通过通过mid一直向左试探
     * 显然a[mid]一定不可能大于target，那么只有两种可能
     *  - (1) a[mid] < target，此时a[l]一定是小于target的，应该将l向右收缩 l = mid + 1
     *  - (2) a[mid] = target，此时应该继续尝试往左，因此h = mid-1
     *
     * 这个过程一直持续到何时为止呢? 通过上面1、2两点可以分析，只要a[l]等于target，那么l在后面的运算中就不可能继续收缩了，
     * 因此最终l=h时有两种结果
     *  a[l] < target：此时l=mid+1=h+1，而a[h+1]一定是等于target的，否则违反了迭代规律
     *  a[l] = target
     *  所以leftMostIndex的值为l的最终值
     *  有一种例外的情况，会导致l一直向右收缩，就是target不在数组中，此时l最终的值为len，因此需要检查这种边界情况
     *
     *  同理，rightMostIndex的最终值应该是h或l-1
     *
     *
     * @param nums
     * @param target
     * @param isfindLeftMost
     * @return
     */
    private static int findIndex(int[] nums, int target, boolean isfindLeftMost) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > target) {
                h = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                if (isfindLeftMost) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return isfindLeftMost ? l : l - 1;
    }




    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
