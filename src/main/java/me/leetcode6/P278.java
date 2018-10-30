package me.leetcode6;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P278 {

    public boolean isBadVersion(int version) {
        // supposed function
        return true;
    }

    /**
     * 典型的二分查找的变种
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            // 防止算术溢出
            int m = l + (r - l) / 2;

            // 如果m是badversion，则最小的badversion起码是m，因此r转移到m处
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }

            // 也可以这么写
//            if (!isBadVersion(m)) {
//                l = m + 1;
//            } else {
//                r = m;
//            }
        }

        // 最后l==r，此时应判断一下是否是badverson
        if (isBadVersion(l)) {
            return l;
        } else {
            return -1;
        }
    }
}
