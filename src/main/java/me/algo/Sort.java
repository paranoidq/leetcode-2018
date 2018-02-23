package me.algo;

import me.leetcode1.P1;

import java.util.Arrays;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class Sort {


    public static void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > current) {
                    // 将已排序的元素往后移，空出候选位置j-1来（下一轮迭代的j）
                    array[j] = array[j - 1];
                } else {
                    array[j] = current;
                    break;
                }
            }

            // 这样写也是可以的
//            for (int j = i - 1; j >= 0; j++) {
//                if (array[j] > current) {
//                    array[j + 1] = array[j];
//                } else {
//                    array[j + 1] = current;
//                    break;
//                }
//            }
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        insertSort(array);

        System.out.println(Arrays.toString(array));
    }
}
