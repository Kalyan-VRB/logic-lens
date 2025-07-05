package org.logiclens.arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int area;
            if (height[i] < height[j]) {
                area = (j - i) * height[i];
                i++;
            } else {
                area = (j - i) * height[j];
                j--;
            }
            result = Math.max(result, area);
        }
        return result;
    }
}
