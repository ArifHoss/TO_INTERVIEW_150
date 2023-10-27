package org.arif.sliding_window;

public class MWSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("a", "aa"));

    }

    public static String minWindow(String s, String t) {
        int[] tCount = new int[128]; // Assuming ASCII characters for character frequency counting
        int[] windowCount = new int[128];

        // Count the frequency of characters in t
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        int left = 0;
        int right = 0;
        int requiredChars = t.length();
        int minLen = Integer.MAX_VALUE;
        int minWindowStart = 0;

        while (right < s.length()) {
            char currentCharRight = s.charAt(right);
            windowCount[currentCharRight]++;

            // Check if the character in s is in t and not exceeding the required count
            if (tCount[currentCharRight] > 0 && windowCount[currentCharRight] <= tCount[currentCharRight]) {
                requiredChars--;
            }

            // Shrink the window from the left side
            while (requiredChars == 0) {
                // Update minimum window length and starting position
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minWindowStart = left;
                }

                char currentCharLeft = s.charAt(left);
                windowCount[currentCharLeft]--;

                // Check if a character in s is in t and needs to be included again
                if (tCount[currentCharLeft] > 0 && windowCount[currentCharLeft] < tCount[currentCharLeft]) {
                    requiredChars++;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minLen);
    }


}
