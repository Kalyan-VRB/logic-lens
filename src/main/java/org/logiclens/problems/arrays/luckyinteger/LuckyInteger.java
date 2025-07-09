package org.logiclens.problems.arrays.luckyinteger;

public class LuckyInteger {
    public int findLucky(int[] arr){
        int[] freq = new int[500];
        for(int num: arr){
            freq[num - 1] += 1;
        }
        for(int i = 500; i > 0; i--){
            if(freq[i - 1] == i) return i;
        }
        return -1;
    }
}
