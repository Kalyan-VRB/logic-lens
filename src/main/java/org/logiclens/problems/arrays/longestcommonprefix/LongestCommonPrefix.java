package org.logiclens.problems.arrays.longestcommonprefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String string : strings) {
            minLen = Math.min(minLen, string.length());
        }
        for (int c = 0; c < minLen; c++) {
            char ch = strings[0].charAt(c);
            for (int i = 1; i < strings.length; i++) {
                if (strings[i].charAt(c) != ch) {
                    return strings[0].substring(0, c);
                }
            }
        }
        return strings[0].substring(0, minLen);
    }
}
