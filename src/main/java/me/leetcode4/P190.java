package me.leetcode4;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P190 {

    public int reverseBits(int n) {
        int count = Integer.SIZE;

        int result = 0;
        for (int i = 0; i < count; i++) {
            result += n & 1;
            n >>>= 1;   // 无符号右移1位
            if (i < 31) {  // 每次将result左移一位，但最后一位不需要再shift了
                result <<= 1;
            }
        }
        return result;
    }
}
