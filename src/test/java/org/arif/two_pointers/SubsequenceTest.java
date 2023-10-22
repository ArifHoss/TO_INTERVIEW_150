package org.arif.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsequenceTest {

    @Test
    public void testIsSubsequence_basicScenarioTrue() {
        String s = "abc";
        String t = "ahbgdc";
        assertTrue(Subsequence.isSubsequence(s, t));
        assertTrue(Subsequence.isSubsequence1(s, t));
    }

    @Test
    public void testIsSubsequence_basicScenarioFalse() {
        String s = "axc";
        String t = "ahbgdc";
        assertFalse(Subsequence.isSubsequence(s, t));
        assertFalse(Subsequence.isSubsequence1(s, t));
    }

    @Test
    public void testIsSubsequence_emptySubsequence() {
        String s = "";
        String t = "ahbgdc";
        assertTrue(Subsequence.isSubsequence(s, t)); // An empty string is a subsequence of any string
        assertTrue(Subsequence.isSubsequence1(s, t)); // An empty string is a subsequence of any string
    }

    @Test
    public void testIsSubsequence_bothEmpty() {
        String s = "";
        String t = "";
        assertTrue(Subsequence.isSubsequence(s, t)); // An empty string is a subsequence of another empty string
        assertTrue(Subsequence.isSubsequence1(s, t)); // An empty string is a subsequence of another empty string
    }

    @Test
    public void testIsSubsequence_sameStrings() {
        String s = "hello";
        String t = "hello";
        assertTrue(Subsequence.isSubsequence(s, t)); // Identical strings
        assertTrue(Subsequence.isSubsequence1(s, t)); // Identical strings
    }

    @Test
    public void testIsSubsequence_singleCharacterTrue() {
        String s = "b";
        String t = "abc";
        assertTrue(Subsequence.isSubsequence(s, t));
        assertTrue(Subsequence.isSubsequence1(s, t));
    }

    @Test
    public void testIsSubsequence_singleCharacterFalse() {
        String s = "d";
        String t = "abc";
        assertFalse(Subsequence.isSubsequence(s, t));
        assertFalse(Subsequence.isSubsequence1(s, t));
    }
}