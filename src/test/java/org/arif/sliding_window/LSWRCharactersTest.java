package org.arif.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LSWRCharactersTest {

    @Test
    void lengthOfLongestSubstring() {
        LSWRCharacters lswrCharacters = new LSWRCharacters();
        String s = "abcabcbb";
        int expected = lswrCharacters.lengthOfLongestSubstring(s);
        int actual = 3;

        assertEquals(actual, expected);
    }
}