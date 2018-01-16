package me.algo;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class CyclicArraySort {

    private static final int SIZE = 8;
    private static int[] a = new int[SIZE];
    static {
        a[3] = 5;
        a[4] = 4;
        a[5] = 6;
        a[6] = 3;
        a[7] = 2;
        a[0] = 1;
        a[1] = Integer.MAX_VALUE;
        a[2] = Integer.MAX_VALUE;
    }
    private static int f = 3;
    private static int b = 1;

    public static void sort(int[] a, int f, int b) {
        int n = a.length;
        for (int i = f; i < (b + n); i++) {
            int smIdx = i;
            int tmpSm = a[i%n];
            for (int j = i + 1; j < b + n; j++) {
                if (a[j%n] < tmpSm) {
                    smIdx = j;
                    tmpSm = a[j % n];
                }
            }
            swap(a, i%n, smIdx%n);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        sort(a, f, b);
        System.out.println(Arrays.toString(a));
    }

}
