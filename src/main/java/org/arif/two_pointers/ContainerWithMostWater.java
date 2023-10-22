package org.arif.two_pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int maximumArea = calculateMaximumArea(heights);
        System.out.println(maximumArea);
    }
    public static int calculateMaximumArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int maximumArea = 0;
        while (leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int minHeight = Math.min(heights[leftPointer], heights[rightPointer]);
            maximumArea = Math.max(maximumArea, width * minHeight);
            if (heights[leftPointer] < heights[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maximumArea;
    }
}

/**
 * Intuition:
 * The fundamental intuition behind this algorithm is that the amount of water a container can hold is determined by
 * two factors: the width between the bars and the height of the shorter bar. To maximize the amount of water, we
 * need a good balance between the width and the height. The algorithm starts with the maximum possible width and
 * then tries to find a better height by moving the pointers inward from both sides. We dismiss positions that cannot
 * possibly hold more water than our current maximum.

 * Approach:
 * Initialize Two Pointers: Start with two pointers, one at the beginning (leftPointer) and one at the end (rightPointer)
 * of the array. This gives us the maximum width to start with.

 * Calculate Area: For the pair of bars currently pointed to, calculate the area of water they would hold, which is the
 * distance between them (width) multiplied by the height of the shorter bar (currentHeight). Maintain a variable
 * (maximumArea) to hold the maximum area encountered so far.

 * Move Pointers: Decide which pointer to move. If the left bar is shorter than the right bar, move the left pointer one
 * step to the right, because we hope to find a taller bar this way. If the right bar is shorter (or equal), move the
 * right pointer one step to the left. The rationale is that we're trying to increase the minimum of the pair
 * (the effective height) since the width is already decreasing.
 * Loop Until Pointers Meet: Continue the process until the two pointers meet, at which point, we've considered all
 * viable pairs.

 * Result: The value of maximumArea after the pointers meet is the maximum amount of water that can be held.

 * Complexity:
 * Time Complexity: The time complexity of this algorithm is O(n), where n is the number of bars (or the length of the
 * input array). This is because we essentially move the leftPointer and rightPointer inward in each step of the
 * algorithm, and each pointer traverses the array only once.

 * Space Complexity: The space complexity is O(1) because the extra space required (for variables like leftPointer,
 * rightPointer, maximumArea, width, and currentHeight) does not depend on the size of the input array and is constant
 * throughout the function.
 */

