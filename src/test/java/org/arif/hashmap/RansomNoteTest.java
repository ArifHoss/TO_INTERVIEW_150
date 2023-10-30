package org.arif.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {

    @Test
    public void testBasicCases() {
        assertFalse(RansomNote.canConstruct("a", "b"));
        assertFalse(RansomNote.canConstruct("aa", "ab"));
        assertTrue(RansomNote.canConstruct("aa", "aab"));
    }

    @Test
    public void testEdgeCases() {
        // Both strings are empty
        assertTrue(RansomNote.canConstruct("", ""));

        // Ransom note is empty
        assertTrue(RansomNote.canConstruct("", "a"));

        // Magazine is empty
        assertFalse(RansomNote.canConstruct("a", ""));

        // Ransom note with repeating characters not in magazine
        assertFalse(RansomNote.canConstruct("aaa", "aab"));

        // Magazine contains every letter except one
        assertTrue(RansomNote.canConstruct("abc", "bacd"));
    }

    @Test
    public void testLargeInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append('a');
        }
        String longString = sb.toString();

        // Large strings with enough characters
        assertTrue(RansomNote.canConstruct(longString, longString + "b"));

        // Large strings, just one character short
        assertFalse(RansomNote.canConstruct(longString + "b", longString));
    }
}