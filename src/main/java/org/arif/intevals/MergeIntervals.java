package org.arif.intevals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> combinedIntervals = new LinkedList<>();
        for (int[] interval : intervals) {
            if (combinedIntervals.isEmpty() || combinedIntervals.getLast()[1] < interval[0]) {
                combinedIntervals.add(interval);
            } else {
                combinedIntervals.getLast()[1] = Math.max(combinedIntervals.getLast()[1], interval[1]);
            }
        }
        return combinedIntervals.toArray(new int[combinedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};

        int[][] mergeIn = mergeIntervals(intervals);
        System.out.println(Arrays.deepToString(mergeIn));
    }
}
