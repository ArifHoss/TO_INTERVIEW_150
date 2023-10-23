package org.arif.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSizeSubarraySumTest {

    @Test
    void minSubArrayLen_01() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int actual = minimumSizeSubarraySum.minSubArrayLen(target, nums);
        int expected = 2;
        assertEquals(expected, actual);

    }

    @Test
    void minSubArrayLen_02() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2, 11, 1, 2, 4, 3,11,1};
        int target = 22;
        int actual = minimumSizeSubarraySum.minSubArrayLen(target, nums);
        int expected = 6;
        assertEquals(expected, actual);

    }
    @Test
    void minSubArrayLen_03() {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2, 11, 1, 2, 4, 3,11,1};
        int target = 22;
        int actual = minimumSizeSubarraySum.calculateMinimumSubArrayLength(target, nums);
        int expected = 6;
        assertEquals(expected, actual);

    }
}