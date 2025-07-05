package org.logiclens.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    private final LongestCommonPrefix solver = new LongestCommonPrefix();

    @Test
    public void testExample1() {
        String result = solver.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertEquals("fl", result);
    }

    @Test
    public void testExample2() {
        String result = solver.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        assertEquals("", result);
    }

    @Test
    public void testExample3() {
        String result = solver.longestCommonPrefix(new String[]{"", "racecar", "car"});
        assertEquals("", result);
    }

    @Test
    public void testExample4() {
        String result = solver.longestCommonPrefix(new String[]{"", "car", "car"});
        assertEquals("", result);
    }

    @Test
    public void testExample5() {
        String result = solver.longestCommonPrefix(new String[]{"car", "car", "car"});
        assertEquals("car", result);
    }
}
