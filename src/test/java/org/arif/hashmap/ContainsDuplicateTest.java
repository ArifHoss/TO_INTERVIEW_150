package org.arif.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @Test
    void containsNearbyDuplicate() {
        assertTrue(ContainsDuplicate.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        assertTrue(ContainsDuplicate.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        assertFalse(ContainsDuplicate.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}