package me.leetcode5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P202 {

    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<>();
        int ss = cal(n);
        while (ss != 1 && !cache.contains(ss)) {
            cache.add(ss);
            ss = cal(ss);
        }

        if (ss == 1) {
            return true;
        } else {
            // System.out.println(ss);
        }
        return false;
    }

    public int cal(int n) {
        int ss = 0;
        while (n > 0) {
            ss += Math.pow(n % 10, 2);
            n /= 10;
        }
        return ss;
    }

    public static void main(String[] args) {
        int n = 17;

        boolean rst = new P202().isHappy(n);
        System.out.println(rst);

    }
}
