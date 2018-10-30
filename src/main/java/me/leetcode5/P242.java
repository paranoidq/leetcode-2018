package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P242 {

    /**
     * 需要排序，复杂度为nlogn
     *
     * @param s
     * @param t
     * @return
     */
    /*
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }
    */


    /**
     * 无需排序，复杂度n
     *
     * @param s
     * @param string
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
