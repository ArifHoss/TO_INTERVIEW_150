package org.arif.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaindromeTest {

    @Test
    void isPlaindrome() {
        Plaindrome plaindrome = new Plaindrome();

        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = "";

        assertTrue(plaindrome.isPlaindrome(s));
        assertFalse(plaindrome.isPlaindrome(s1));
        assertTrue(plaindrome.isPlaindrome(s2));
    }
}