package org.logiclens.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {
    private static final double DELTA = 0.00001;
    private final MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();

    @Test
    public void testExample1() {
        double result = solver.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertEquals(2.0, result, DELTA);
    }

    @Test
    public void testExample2() {
        double result = solver.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assertEquals(2.5, result, DELTA);
    }

    @Test
    public void testExample3() {
        double result = solver.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 4, 7, 9, 10});
        assertEquals(3.5, result, DELTA);
    }

    @Test
    public void testExample4() {
        double result = solver.findMedianSortedArrays(new int[]{-5, -3, -1}, new int[]{1, 4, 7, 9, 10});
        assertEquals(2.5, result, DELTA);
    }

    @Test
    public void testExample5() {
        double result = solver.findMedianSortedArrays(new int[]{-5, -3, -1}, new int[]{-10, -2, -1, 0, 1});
        assertEquals(-1.5, result, DELTA);
    }

    @Test
    public void testExample6() {
        double result = solver.findMedianSortedArrays(new int[]{}, new int[]{-10, -2, -1, 0, 1});
        assertEquals(-1.0, result, DELTA);
    }

    @Test
    public void testExample7() {
        try {
            solver.findMedianSortedArrays(new int[]{}, new int[]{});
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Inputs", e.getMessage());
        }
    }

}
