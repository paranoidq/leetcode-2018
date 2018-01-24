package me.leetcode1;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length < 1) {
            return ans;
        }
        if (strs.length == 1) {
            ans.add(Arrays.asList(strs[0]));
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = key(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        for (List<String> anagrams : map.values()) {
            ans.add(anagrams);
        }
        return ans;
    }


    private static String key(String a) {
        char[] aChars = a.toCharArray();
        Arrays.sort(aChars);
        return new String(aChars);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }
}
