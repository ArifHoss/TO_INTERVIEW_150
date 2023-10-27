package org.arif.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            int complement = numbers[leftPointer] + numbers[rightPointer];
            if (complement == target) {
                return new int[]{leftPointer + 1, rightPointer + 1};

            } else if (complement > target) {
                rightPointer--;
            } else {
                leftPointer++;
            }

        }
        throw new IllegalArgumentException("INVALID_INPUT");
    }

    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int left = target - numbers[i];
            if (map.containsKey(left)) {
                return new int[]{map.get(left), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        throw new IllegalArgumentException("INVALID_INPUT");
    }
}
