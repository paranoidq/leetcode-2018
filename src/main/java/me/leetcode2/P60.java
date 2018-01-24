package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P60 {

    public static String getPermutation(int n, int k) {
        if (n <= 0 && k <= 0) {
            throw new IllegalArgumentException("illegal argument");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        char[] chars = sb.toString().toCharArray();
        for (int i = 1; i < k; i++) {
            next(chars);
        }
        return new String(chars);
    }

    private static void next(char[] s) {
        int i = s.length - 2;
        while (i >= 0) {
            if (s[i] - '0' < s[i + 1] - '0') {
                break;
            }
            i--;
        }

        if (i < 0) {
            throw new IllegalArgumentException("k exceeds all permutations");
        }

        int j = s.length - 1;
        while (j> i) {
            if (s[j] - '0' > s[i] - '0') {
                break;
            }
            j--;
        }

        swap(s, i, j);
        int b = i + 1, e = s.length - 1;
        while (b < e) {
            swap(s, b++, e--);
        }
    }

    private static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(5, 121));
    }
}
