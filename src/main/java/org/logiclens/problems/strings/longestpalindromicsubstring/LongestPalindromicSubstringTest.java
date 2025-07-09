package org.logiclens.problems.strings.longestpalindromicsubstring;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LongestPalindromicSubstringTest {
    private final LongestPalindromicSubstring solver = new LongestPalindromicSubstring();
    @Test
    public void testExample1(){
        String result = solver.longestPalindromicSubstring("cabad");
        assertEquals("aba", result);
    }
    @Test
    public void testExample2(){
        String result = solver.longestPalindromicSubstring("abcd");
        assertTrue(Set.of("a", "b", "c", "d").contains(result));
    }
    @Test
    public void testExample3(){
        String result = solver.longestPalindromicSubstring("a");
        assertEquals("a", result);
    }
    @Test
    public void testExample4(){
        String result = solver.longestPalindromicSubstring("");
        assertEquals("", result);
    }

    @Test
    public void testExample5(){
        String result = solver.longestPalindromicSubstring(null);
        assertEquals("", result);
    }
}