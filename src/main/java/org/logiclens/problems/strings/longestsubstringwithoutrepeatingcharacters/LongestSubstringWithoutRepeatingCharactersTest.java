package org.logiclens.problems.strings.longestsubstringwithoutrepeatingcharacters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private final LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();
    @Test
    public void testExample1(){
        int result = solver.lengthOfLongestSubstring("abcabc");
        assertEquals(3, result);
    }
    @Test
    public void testExample2(){
        int result = solver.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, result);
    }
    @Test
    public void testExample3(){
        int result = solver.lengthOfLongestSubstring("hgfkjdg");
        assertEquals(6, result);
    }
    @Test
    public void testExample4(){
        int result = solver.lengthOfLongestSubstring("abcdbc");
        assertEquals(4, result);
    }
}