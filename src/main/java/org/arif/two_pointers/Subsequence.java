package org.arif.two_pointers;

/** Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
 * of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class Subsequence {

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;

        }
        return false;
    }

    public static boolean isSubsequence1(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex += 1;
            }
            tIndex += 1;
        }
        return sIndex == s.length();
    }
}

/*
  Intuition
  --------
  My initial thought is to traverse both strings "s" and "t" while comparing their characters. If a character in "s"
  matches the character in "t", move to the next character in "s". If we can traverse the entire string "s" this way,
  it means "s" is a subsequence of "t".

  Approach
  -------
  The method uses two pointers: indexS and indexT for strings "s" and "t" respectively. Initially, both pointers are at
  the start of each string. We traverse "t" and at each step:

  Compare the character at indexT of "t" with the character at indexS of "s".
  If they match, increment indexS (move to the next character in "s").
  If indexS reaches the end of "s", return true because we've found "s" in "t".
  If they don't match, continue with the next character in "t" by incrementing indexT.
  If we finish traversing "t" but not "s", return false.

  Complexity
 ----------
  Time complexity:
  O(n), where n is the length of string "t". This is because in the worst case, we're traversing the entire string "t" once.
  Space complexity:
  O(1), since we're not using any additional data structures that grow with the input size. We're only using primitive
  variables, which occupy constant space.
 */