package org.logiclens.problems.arrays.luckyinteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LuckyIntegerTest {
    private final LuckyInteger solver = new LuckyInteger();
    @Test
    public void testExample1(){
        int result = solver.findLucky(new int[]{1, 2, 2, 3, 3, 3});
        assertEquals(3, result);
    }
    @Test
    public void testExample2(){
        int result = solver.findLucky(new int[]{2, 3, 2, 4});
        assertEquals(2, result);
    }
    @Test
    public void testExample3(){
        int result = solver.findLucky(new int[]{2, 2, 2, 3, 3});
        assertEquals(-1, result);
    }
    @Test
    public void testExample4(){
        int result = solver.findLucky(new int[]{1, 2, 3, 4, 5});
        assertEquals(1, result);
    }
}
