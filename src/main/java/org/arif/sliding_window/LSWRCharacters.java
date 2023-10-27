package org.arif.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LSWRCharacters { // Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int sLength = s.length();
        int answer = 0, leftPointer = 0, rightPointer = 0;
        while (leftPointer < sLength && rightPointer < sLength) {
            if (!set.contains(s.charAt(rightPointer))) {
                set.add(s.charAt(rightPointer++));
                answer = Math.max(answer, rightPointer - leftPointer);
            } else {
                set.remove(s.charAt(leftPointer++));
            }
        }
        return answer;
    }
}
