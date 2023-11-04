package org.arif.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] nums1 = {2, 7, 11, 15};
        int[] twoSum = twoSum(nums, 9);
        int[] twoSum1 = twoSum1(nums, 9);
        int[] twoSum2 = twoSum1(nums, 18);
        System.out.println(Arrays.toString(twoSum));
        System.out.println(Arrays.toString(twoSum1));
        System.out.println(Arrays.toString(twoSum2));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remained = target - nums[i];
            if (map.containsKey(remained)) {
                return new int[]{map.get(remained),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("INVALID_INPUT");
    }

    public static int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
