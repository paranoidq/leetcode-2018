package me.leetcode1;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P38 {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String s = "1";
        // 从"1"开始，那么计数值就是n-1次
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length() - 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count).append(s.charAt(j));
                    // reset
                    count = 1;
                }
            }

            // 注意最后一组元素，在循环里没法判断，需要在循环后面添加
            sb.append(count).append(s.charAt(s.length() - 1));
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }
}
