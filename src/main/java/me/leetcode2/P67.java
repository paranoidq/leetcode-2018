package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P67 {

    public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty() ) {
            return a;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int carry = 0;
        int i = aChars.length - 1;
        int j = bChars.length - 1;
        int n = (i > j ? i : j) + 1;

        char[] ans = new char[n];
        int k = n - 1;
        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? aChars[i--] - '0' : 0;
            int d2 = j >= 0 ? bChars[j--] - '0' : 0;

            int val = d1 + d2 + carry;
            carry = val >= 2 ? 1 : 0;
            ans[k--] = val % 2 == 0 ? '0' : '1';
        }

        if (carry > 0) {
            char[] tmp = ans;
            ans = new char[ans.length + 1];
            System.arraycopy(tmp, 0, ans, 1, tmp.length);
            ans[0] = '1';
        }
        return new String(ans);
    }

    // 更简介清晰的写法
    public static String addBinary1(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;
        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int d1 = (i < 0) ? 0 : a.charAt(i) - '0';
            int d2 = (j < 0) ? 0 : b.charAt(j) - '0';

            int v = d1 + d2 + carry;
            carry = v / 2;
            v = v % 2;
            sb.append(v);
        }
        sb.append(carry > 0 ? 1 : "");
        sb.reverse();
        return sb.toString();
    }


    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
