package org.arif.intevals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> summaryRanges = summaryRanges(nums);
        System.out.println(summaryRanges);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();
        int start = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start != nums[i]) {
                    range.add(start + "->" + nums[i]);
                } else {
                    range.add(String.valueOf(start));
                }
                if (i < nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return range;
    }
}
