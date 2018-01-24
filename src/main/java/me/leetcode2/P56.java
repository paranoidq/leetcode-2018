package me.leetcode2;

import me.leetcode1.P5;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P56 {

    private static class Interval {
        int start;
        int end;

        public Interval() {

        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.start < interval2.start) {
                    return -1;
                } else if (interval1.start > interval2.start){
                    return 1;
                } else {
                    if (interval1.end < interval2.end) {
                        return -1;
                    } else if (interval1.end == interval2.end) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });

        List<Interval> ans = new ArrayList<>();
        ans.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interset(ans.get((ans.size() - 1)), interval)) {
                Interval merged = doMerge(ans.remove(ans.size() - 1), interval);
                ans.add(merged);
            } else {
                ans.add(interval);
            }
        }
        return ans;
    }

    private static Interval doMerge(Interval i1, Interval i2) {
        int start = i1.start;
        int end = Math.max(i1.end, i2.end);
        return new Interval(start, end);
    }

    private static boolean interset(Interval i1, Interval i2) {
        if (i1.end < i2.start) {
            return false;
        } else {
            return true;
        }
    }


    // 更为简洁清晰的写法
    public static List<Interval> merge2(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start < i2.start ? -1 : (i1.start == i2.start ? 0 : 1);
            }
        });
        LinkedList<Interval> ans = new LinkedList<>();
        for (Interval interval : intervals) {
            // ans为空 或 区间不重叠
            if (ans.isEmpty() || ans.getLast().end < interval.start) {
                ans.add(interval);
            } else {
            // 区间重叠，更新end为较大的那个值，因为事先排序了，start一定是不会变的
                ans.getLast().end = Math.max(ans.getLast().end, interval.end);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(intervals);
        System.out.println(merge(intervals));
    }
}
