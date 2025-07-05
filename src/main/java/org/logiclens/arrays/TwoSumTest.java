package org.logiclens.arrays;
import org.junit.Test;
import static org.junit.Assert.*;
public class TwoSumTest {
    private final TwoSum solver = new TwoSum();
    @Test
    public void testExample1(){
        int[] result = solver.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }
    @Test
    public void testExample2(){
        int[] result = solver.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result);
    }
    @Test
    public void testExample3(){
        int[] result = solver.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
