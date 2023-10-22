package org.arif.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    @Test
    public void calculateMaximumArea_basicScenario() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, ContainerWithMostWater.calculateMaximumArea(height));
    }

    @Test
    public void calculateMaximumArea_withEqualHeights() {
        int[] height = {1, 1};
        assertEquals(1, ContainerWithMostWater.calculateMaximumArea(height));
    }

    @Test
    public void calculateMaximumArea_withDescendingHeights() {
        int[] height = {8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(16, ContainerWithMostWater.calculateMaximumArea(height));
    }

    @Test
    public void calculateMaximumArea_singleHeight() {
        int[] height = {2};
        assertEquals(0, ContainerWithMostWater.calculateMaximumArea(height)); // Single height cannot form a container
    }

    @Test
    public void calculateMaximumArea_emptyInput() {
        int[] height = {};
        assertEquals(0, ContainerWithMostWater.calculateMaximumArea(height));
    }
}