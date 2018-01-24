package me.leetcode1;

/**
 * 理解乘法算法的计算方式 和 位置
 *
 *
 *  `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
 *
 *  https://drscdn.500px.org/photo/130178585/m=2048/300d71f784f679d5e70fadda8ad7d68f
 *
 * @author paranoidq
 * @since 1.0.0
 */
public class P43 {

    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        // 乘法后的最大长度不会超过两个乘数的长度之和
        int[] pos = new int[m + n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = pos[p2] + multi;
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // 跳过leading zero
            if (sb.length() == 0 && p == 0) {
                continue;
            }
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "";
        String num2 = "";
        System.out.println(multiply(num1, num2));
    }
}
