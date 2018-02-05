package me.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P89 {

    public static List<Integer> grayCode(int n) {
        int maxPow = n;
        List<Integer> ans = new ArrayList<>();
        int code = 0;

        ans.add(code);
        int pow = 0;
        boolean dr = true;
        while (pow < maxPow) {
            if (dr) {
                code += Math.pow(2, pow++);
            } else {
                code -= Math.pow(2, pow++);
            }
            ans.add(code);
            if (pow == maxPow) {
                dr = !dr;
                pow = 0;
                maxPow--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(1));
    }
}
