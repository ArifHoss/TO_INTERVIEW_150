package org.arif.hashmap;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestConsecutive = longestConsecutive(nums);
        System.out.println(longestConsecutive);


    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxength = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) { // Avoid duplicates
                // Get left and right sequence length
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);

                // Current sequence length
                int length = left + right + 1;
                maxength = Math.max(maxength, length);

                // Extend the boundaries of the sequence
                map.put(n, length);

                // Only need to  update the first and last numbers of a sequence
                if (left > 0) {
                    map.put(n - left, length);
                }
                if (right > 0) {
                    map.put(n + right, length);
                }
            }
        }
        return maxength;

    }


    // take more time
    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
