package me.leetcode1;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P15 {

    // Wrong Answer!!!
    // TODO: 如何通过set去除重复的triple
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum2 = nums[i] + nums[j];
                int compliment = -sum2;
                if (map.containsKey(compliment)) {
                    int idx = map.get(compliment);

                    // 排除重复元素
                    if (idx > j) {


                        ans.add(Arrays.asList(nums[i], nums[j], nums[idx]));
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        // 找到的另外两个数必须在后面，所以这里-2
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];

            // l 和 r 代表搜索后两个数的起点和终点
            int l = i + 1;
            int r = nums.length - 1;
            twoSum(nums, l, r, target, ans);
        }
        return ans;
    }

    public static void twoSum(int[] nums, int l, int r, int target, List<List<Integer>> ans) {
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                ans.add(Arrays.asList(-target, nums[l], nums[r]));

                l++;
                r--;

                // 跳过num[l]相同的元素，因为target和num[l]相同，必然会造成重复的triple
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }

                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,0};
        System.out.println(threeSum2(nums));
    }
}
