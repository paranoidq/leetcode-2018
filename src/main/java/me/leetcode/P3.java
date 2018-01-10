package me.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int candidateMax = 0;
        int minIdx = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                int subLen = i - minIdx;
                candidateMax = subLen > candidateMax ? subLen : candidateMax;
                minIdx = minIdx > map.get(ch) + 1 ? minIdx : map.get(ch) + 1;
                map.put(ch, i);
            } else {
                map.put(ch, i);
            }
        }
        int last = chars.length - minIdx;
        return candidateMax >  last? candidateMax : last;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwabcwkep"));
    }
}
