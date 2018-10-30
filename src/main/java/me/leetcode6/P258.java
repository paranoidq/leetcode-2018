package me.leetcode6;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P258 {

    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 9) {
                sum += num % 10;
                num /= 10;
            }
            sum += num;
            num = sum;
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(new P258().addDigits(38));
    }
}
