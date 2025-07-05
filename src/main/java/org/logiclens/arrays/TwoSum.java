package org.logiclens.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Optimized - O(n)
    public int[] twoSum(int[] nums, int target){
        //create a hashmap to store the iterated element and its index
        Map<Integer, Integer> map = new HashMap<>();
        //iterate the nums array
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            //check if the complement is already exists in the map
            if(map.containsKey(complement)){
                //return the indices of the element and its complement
                return new int[]{map.get(complement), i};
            }
            //store the visited element and its index
            map.put(nums[i], i);
        }
        //since the solution always exists
        throw new IllegalArgumentException("No Valid Solution Found!");
    }

    //Brute Force - O(n^2)
    public int[] twoSumBruteForce(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Valid Solution Found!");
    }

}
