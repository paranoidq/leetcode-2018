package me.leetcode5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Object> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            } else {
                map.put(n, "");
            }
        }
        return false;
    }
}
