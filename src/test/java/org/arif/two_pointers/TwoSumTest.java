package org.arif.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    // Normal case: The target can be obtained by adding up two numbers in the array
    @Test
    public void testNormalCase() {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {1, 2}; // indices are 1-based
        assertArrayEquals(expectedResult, twoSum.twoSum(numbers, target));
    }

    // Edge case: The array contains two elements, and their sum equals the target
    @Test
    public void testTwoElements() {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {1, 3};
        int target = 4;
        int[] expectedResult = {1, 2}; // indices are 1-based
        assertArrayEquals(expectedResult, twoSum.twoSum(numbers, target));
    }

    // Edge case: The array contains multiple elements with the same value, which could be used to get the target
    @Test
    public void testDuplicateElements() {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {3, 3, 4, 5};
        int target = 6;
        int[] expectedResult = {1, 2}; // indices are 1-based
        assertArrayEquals(expectedResult, twoSum.twoSum(numbers, target));
    }
}