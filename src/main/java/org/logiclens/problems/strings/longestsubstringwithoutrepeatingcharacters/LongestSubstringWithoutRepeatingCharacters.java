package org.logiclens.problems.strings.longestsubstringwithoutrepeatingcharacters;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int[] visit = new int[256];
        Arrays.fill(visit, -1);
        while(end < s.length()){
            char ch = s.charAt(end);
            if(visit[ch] != -1){
                if(visit[ch] >= start){
                    start = visit[ch] + 1;
                }
            }
            maxLen = Math.max(maxLen, end - start + 1);
            visit[ch] = end;
            end++;
        }
        return maxLen;
    }
}