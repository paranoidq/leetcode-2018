package me.leetcode2;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P55 {

    /**
     * 找出good position，只要从0能到达good position，就能通过good position
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int goodPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goodPos) {
                goodPos = i;
            }
        }
        return goodPos == 0;
    }


    /**
     * 回溯法
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        return backtrack(0, nums);
    }

    private static boolean backtrack(int pos, int[] nums) {
        if (pos == nums.length - 1) {
            return true;
        }
        int furthest = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = pos + 1; nextPos <= furthest; nextPos++) {
            if (backtrack(nextPos, nums)) {
                return true;
            }
        }
        return false;
    }


    enum Index {
        GOOD,
        BAD,
        UNKNOWN,
    }
    private static Index[] memos;
    public static boolean canJump1(int[] nums) {
        memos = new Index[nums.length];
        for (int i = 0; i < memos.length; i++) {
            memos[i] = Index.UNKNOWN;
        }
        memos[memos.length - 1] = Index.GOOD;
        return backtrackWithMemo(0, nums);
    }

    private static boolean backtrackWithMemo(int pos, int[] nums) {
        if (memos[pos] != Index.UNKNOWN) {
            return memos[pos] == Index.GOOD;
        }
        int furthestJump = Math.max(pos + nums[pos], nums.length - 1);
        for (int i = pos + 1; i <= furthestJump; i++) {
            // 递归查找从pos开始的jump能否达到最后，并且进行簿记，方便后续查找
            if (backtrackWithMemo(i, nums)) {
                memos[pos] = Index.GOOD;
                return true;
            }
        }
        memos[pos] = Index.BAD;
        return false;
    }


    /**
     * 将回溯转为非递归的形式，反推，找good position
     * @param nums
     * @return
     */
    public static boolean canJump3(int[] nums) {
        memos = new Index[nums.length];
        for (int i = 0; i < memos.length; i++) {
            memos[i] = Index.UNKNOWN;
        }
        memos[memos.length - 1] = Index.GOOD;

        for (int i = memos.length - 2; i >= 0; i--) {
            int furthestJump = Math.max(i + nums[i], nums.length - 1);
            for (int j = i + 1; j < furthestJump; j++) {
                if (memos[j] == Index.GOOD) {
                    break;
                }
            }
        }

        return memos[0] == Index.GOOD;
    }


    public static void main(String[] args) {
        int[] nums = {2, 0};
        System.out.println(canJump(nums));
    }
}
