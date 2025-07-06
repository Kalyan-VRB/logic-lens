# Longest Substring Without Repeating Characters – Solution Explanation

## Problem Summary

Given a string `s`, find the length of the longest substring without repeating characters.

A substring is a contiguous sequence of characters. If any character repeats, the substring is considered broken.

---

## Brute-Force Approach

**Idea:**  
Check every possible substring, and for each one, determine whether it contains all unique characters.

**Steps:**
1. Iterate with two nested loops: `i` (start index) and `j` (end index).
2. For each substring `s[i..j]`, check if all characters are unique using a `Set`.
3. Track the maximum length found.

**Time Complexity:**
- O(n³): Generating substrings takes O(n²), and checking uniqueness takes up to O(n).

**Space Complexity:**
- O(n): For the temporary set used to check uniqueness.

**Why it's inefficient:**  
It checks all substrings blindly without leveraging previous information.

---

## Optimal Approach: Sliding Window with Character Index Map

**Idea:**  
Use a sliding window to maintain a current substring of unique characters. As we iterate, shrink the window when we find a duplicate.

**Implementation:**
- Use two pointers: `start` and `end` to define the current window.
- Use an array of size 256 (`visit[]`) to store the **last seen index** of characters.
- If a character at `end` is repeated and its last index is ≥ `start`, update `start` to `last_seen + 1`.
- Update `maxLen` at each step.

**Steps:**
1. Initialize `visit[ch] = -1` for all characters.
2. Traverse the string with `end`.
3. If character was seen before in current window, update `start`.
4. Calculate current window length as `end - start + 1` and update `maxLen`.
5. Set `visit[ch] = end`.

**Example:**
Input: `"abcabcbb"`  
Output: `3`  
Explanation: Longest substring without repeating characters is `"abc"`.

---

## Time and Space Complexity

### Time Complexity: `O(n)`
- Each character is processed at most twice — once added to the window and once removed.

### Space Complexity: `O(1)`
- Fixed array of size 256 (for ASCII characters), regardless of input size.

---

## Edge Cases to Consider

- Empty string → Output: 0
- All characters same → Output: 1
- All characters unique → Output: length of the string
- Mix of repeating and unique characters

---

## Summary

The sliding window technique efficiently handles the requirement by avoiding redundant work and reuses previously seen information. It significantly improves performance compared to brute-force methods.
