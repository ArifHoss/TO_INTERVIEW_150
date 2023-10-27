package org.arif.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstringConcatenationWordsTest {

    @Test
    void findSubstring() {
        String sourceString = "barfoothefoobarman";
        String[] targetsWords = {"foo", "bar"};
        List<Integer> expected = SubstringConcatenationWords.findSubstring(sourceString, targetsWords);
        List<Integer> expected1 = SubstringConcatenationWords.findSubstringFromConcatenationWords(sourceString, targetsWords);
        List<Integer> actual = Arrays.asList(0, 9);
        List<Integer> actual1 = Arrays.asList(0, 9);
        assertEquals(actual, expected);
        assertEquals(actual1, expected1);
    }
}