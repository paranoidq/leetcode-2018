package me.leetcode6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P263 {

    /**
     * 递归法
     *
     * @param num
     * @return
     */
    public boolean isUgly1(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        if (num % 2 == 0) {
            return isUgly1(num / 2);
        }
        if (num % 3 == 0) {
            return isUgly1(num / 3);
        }
        if (num % 5 == 0) {
            return isUgly1(num / 5);
        }
        return false;
    }


    /**
     * 递归 + 缓存法
     */
    private Map<Integer, Boolean> cache = new HashMap<>();

    public boolean isUgly2(int num) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        // %大数要放在前面，这样才能利用cache
        if (num % 5 == 0) {
            cache.put(num, isUgly2(num / 5));
            return cache.get(num);
        }
        if (num % 3 == 0) {
            cache.put(num, isUgly2(num / 3));
            return cache.get(num);
        }
        if (num % 2 == 0) {
            cache.put(num, isUgly2(num / 2));
            return cache.get(num);
        }
        return false;
    }


    /**
     * 迭代法，因此尝试除2、3、5
     *
     * @return
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] divisors = {2, 3, 5};
        for (int d : divisors) {
            // 如果/2除不了了，就可以继续除3，后续也不可能再被2除了
            // 同理，如果除3也除不了了，后续楚5之后也不可能除了
            while (num % d == 0) {
                num /= d;
            }
        }

        return num == 1;
    }
}
