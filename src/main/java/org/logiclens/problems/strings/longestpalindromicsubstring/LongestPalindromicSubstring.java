package org.logiclens.problems.strings.longestpalindromicsubstring;

public class LongestPalindromicSubstring {
    public String longestPalindromicSubstring(String s) {
        if(s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expandAround(i, i, s);
            int even = expandAround(i, i + 1, s);
            int maxLen = Math.max(odd, even);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAround(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}