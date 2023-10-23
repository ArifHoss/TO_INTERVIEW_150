package org.arif.sliding_window;


public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 11, 1, 2, 4, 3};
        System.out.println(nums[0]);
        System.out.println(nums[5]);
        System.out.println(nums.length);
        System.out.println(5-0+1);
    }
    public int minSubArrayLen(int target, int[] nums) {

        int minimumSubArrayLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSubArraySum = 0;

        for (int right = 0; right < nums.length; right++) {

            currentSubArraySum += nums[right];

            while (currentSubArraySum >= target) {
                int currentSubArrayLength = right - left + 1;
                minimumSubArrayLength = Math.min(minimumSubArrayLength, currentSubArrayLength);
                currentSubArraySum -= nums[left];
                left++;
            }
        }

        return minimumSubArrayLength == Integer.MAX_VALUE ? 0 : minimumSubArrayLength;
    }

    public int calculateMinimumSubArrayLength(int target, int[] nums) {
        int numElements = nums.length;

        int minSubArrayLength = Integer.MAX_VALUE;

        int startIndex = 0;
        int endIndex = 0;

        int currentSum = 0;

        while (endIndex < numElements) {
            currentSum += nums[endIndex];

            while (currentSum >= target) {
                int currentLength = endIndex - startIndex + 1;

                minSubArrayLength = Math.min(minSubArrayLength, currentLength);

                currentSum -= nums[startIndex];

                startIndex++;
            }

            endIndex++;
        }

        return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
    }

}
