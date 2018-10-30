package me.leetcode5;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P204 {


    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                // ERROR：这里会溢出，必须将i * j的判断条件放到for内部才行
//                for (int j = 2; j < n; j++) {
                for (int j = 2; i * j < n; j++) {
                    if ((i * j) < n) {
                        notPrimes[i * j] = true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new P204().countPrimes(n));
    }


}
