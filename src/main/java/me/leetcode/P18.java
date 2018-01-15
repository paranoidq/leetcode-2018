package me.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int d = nums[i];
            int targetX = target - d;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 注意：这里的j> i+1不能少，否则case：[0,0,0,0]失败
                // 必须是第二个元素开始不能等于前一个元素，第一个元素还是要正常运算！！！
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int c = nums[j];
                int targetY = targetX - c;

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == targetY) {
                        ans.add(Arrays.asList(d, c, nums[l], nums[r]));
                        l++;
                        r--;
                        // 跳过重复元素
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        // 跳过重复元素
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (nums[l] + nums[r] < targetY) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
