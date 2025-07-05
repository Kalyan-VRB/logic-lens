package org.logiclens.arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {
    private final ContainerWithMostWater solver = new ContainerWithMostWater();

    @Test
    public void testExample1() {
        int result = solver.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertEquals(49, result);
    }

    @Test
    public void testExample2() {
        int result = solver.maxArea(new int[]{1, 1, 1, 1});
        assertEquals(3, result);
    }

    @Test
    public void testExample3() {
        int result = solver.maxArea(new int[]{1, 2});
        assertEquals(1, result);
    }

    @Test
    public void testExample4() {
        int result = solver.maxArea(new int[]{1, 0});
        assertEquals(0, result);
    }
}
