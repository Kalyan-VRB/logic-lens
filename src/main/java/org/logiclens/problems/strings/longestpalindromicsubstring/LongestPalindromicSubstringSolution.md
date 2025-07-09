# Longest Palindromic Substring – Solution Explanation

## Problem Summary

Given a string `s`, find the longest substring in `s` which is a palindrome.  
A palindrome is a string that reads the same forward and backward.

---

## Approach: Expand Around Center

### Key Idea:

Every palindrome mirrors around its center.  
A palindrome can have either:
- **Odd length**: center at a single character (`i`)
- **Even length**: center between two characters (`i`, `i+1`)

There are `2n - 1` such centers in a string of length `n`.

For each center:
1. Expand outward as long as the characters match on both sides.
2. Track the maximum length and corresponding start and end indices.

---

### Steps:

1. **Initialize `start` and `end`** to track the current longest palindrome.
2. **Loop through each index `i`** in the string:
    - Treat `i` as the center of an **odd-length** palindrome.
    - Treat `i` and `i+1` as the center of an **even-length** palindrome.
3. For each expansion, calculate the palindrome length.
4. If the found length is greater than the previous maximum, update `start` and `end` accordingly.
5. Return `s.substring(start, end + 1)` as the result.

---

### Example:

#### Input: `"babad"`

- Center at `i = 0`: expands to `"b"`
- Center at `i = 1`: expands to `"bab"`
- Center at `i = 2`: expands to `"aba"`
- Longest palindromic substrings: `"bab"` or `"aba"`

Output: `"bab"` (or `"aba"`, depending on implementation)

---

## Time and Space Complexity

| Complexity | Value                                                               |
|------------|---------------------------------------------------------------------|
| **Time**   | `O(n^2)` — Worst case, each center expands to whole string          |
| **Space**  | `O(1)` — Constant extra space (no DP table or recursion stack used) |

---

## Comparison with Brute Force

| Approach           | Time Complexity | Space Complexity | Notes                                       |
|--------------------|-----------------|------------------|---------------------------------------------|
| Brute Force        | `O(n^3)`        | `O(n)`           | Check all substrings and validate each one  |
| Expand from Center | `O(n^2)`        | `O(1)`           | Much faster in practice; avoids extra space |

---

## Conclusion

The "Expand Around Center" method is an elegant and efficient way to solve the longest palindromic substring problem.  
It avoids unnecessary space usage and performs well for input sizes up to ~1000 characters.

