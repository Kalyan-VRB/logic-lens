# Longest Common Prefix – Solution Explanation

## Problem Statement

Given an array of strings, return the longest common prefix string among them.

If there is no common prefix, return an empty string `""`.

---

## Optimal Approach – Character-by-Character Scan

### Key Idea

- Start by assuming the first string is the reference.
- For each character position `c` (from 0 to `minLen - 1`, where `minLen` is the length of the shortest string), compare that character across all strings.
- If a mismatch is found at any point, return the prefix up to that character.
- If no mismatch occurs, return the first `minLen` characters of the reference string.

This technique avoids unnecessary comparisons and exits early if a mismatch is detected.

---

## Steps

1. **Handle Edge Cases:**
    - If the array is null or empty, return `""`.

2. **Find the Length of the Shortest String:**
    - This bounds how far we need to check character-by-character.

3. **Compare Characters Column by Column:**
    - For each character index up to `minLen`, check if all strings have the same character at that index.
    - If a mismatch is found, return the substring from `0` to current index.

4. **If No Mismatch:**
    - Return the substring from index `0` to `minLen`.

---

## Time and Space Complexity

### Time Complexity: O(S)

- `S` is the total number of characters in all strings.
- In the worst case (all strings are the same), the algorithm compares each character once across all strings.

More precisely:  
**O(minLen × N)**, where:
- `minLen` = length of the shortest string
- `N` = number of strings

### Space Complexity: O(1)

- Only a few integer variables are used.
- No additional data structures are created.
- Return value is a substring (view of original string in Java, so no extra space in memory).

---

## Brute Force vs Optimal Approach

| Metric               | Brute Force                          | Optimal (Character-by-Character)   |
|----------------------|--------------------------------------|-------------------------------------|
| Strategy             | Check all prefixes of the shortest string, see if all strings start with it | Compare characters index by index |
| Time Complexity      | O(N × minLen²) (in worst-case with prefix building and checking) | O(N × minLen)                      |
| Space Complexity     | O(minLen) (for temporary prefix building) | O(1)                               |
| Early Exit?          | Often loops unnecessarily            | Returns as soon as a mismatch is found |
| Practical Efficiency | Slower, especially with long strings | Fast and scalable                  |
| Elegance & Clarity   | Slightly verbose                     | Clean and interview-friendly       |

---

## Summary

- This optimized character-by-character solution is the **most efficient** for solving the Longest Common Prefix problem.
- It ensures early termination, avoids unnecessary string operations, and uses constant space.
- It's widely used in coding interviews and real-world systems when handling prefix-based grouping or validation.
