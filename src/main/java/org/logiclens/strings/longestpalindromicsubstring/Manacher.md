# Longest Palindromic Substring – Solution Explanation

## Problem Statement

Given a string `s`, return the longest palindromic substring in `s`.

---

## Optimal Solution – Manacher's Algorithm (O(n) Time)

Manacher’s Algorithm efficiently finds the longest palindromic substring in linear time by transforming the input and expanding around centers while avoiding redundant comparisons.

---

## Step-by-Step Breakdown

### 1. Preprocess the String

We convert the original string into a new string where each character is separated by `#`, and we add special characters `^` and `$` to avoid bounds checking.

Example:
Original: "abba"
Transformed: "^#a#b#b#a#$"
Index: 0 1 2 3 4 5 6 7 8 9 10


This ensures all palindromes in the new string are of **odd length**, simplifying expansion logic.

---

### 2. Define Data Structures

We use:
- `p[i]`: the radius of the longest palindrome centered at index `i`
- `center`: the center of the current known palindrome
- `right`: the right boundary of this palindrome

We iterate from `i = 1` to `n - 2` (excluding sentinels), expanding palindromes and updating these values as necessary.

---

### 3. Expansion Logic & Mirror Optimization

For each position `i`, we check its **mirror index** with respect to the current `center`:
mirror = 2 * center - i

If `i < right`, we initialize:
p[i] = min(right - i, p[mirror])

Then, we expand around `i` as long as the characters match:
while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
p[i]++;
}

If expansion goes beyond `right`, we update `center` and `right`.

---

### 4. Example Walkthrough – "abba"

Transformed string:
^ # a # b # b # a # $

Index:
0 1 2 3 4 5 6 7 8 9 10

At `i = 5` (centered on `#` between `b` and `b`), we expand outward:
- `t[4] == t[6] → b == b`
- `t[3] == t[7] → # == #`
- `t[2] == t[8] → a == a`
- `t[1] == t[9] → # == #`

Expansion stops when `t[0] = ^` and `t[10] = $` don't match. So, the radius is `4`, centered at `i = 5`.

To get the start index in the original string:
start = (centerIndex - maxLen) / 2 = (5 - 4) / 2 = 0

Length = 4 → substring = `"abba"`

---

### 5. Extract Result

To find the starting index in the original string:
start = (centerIndex - maxLen) / 2

Return:
s.substring(start, start + maxLen)


---

## Time & Space Complexity

| Metric       | Value       |
|--------------|-------------|
| Time         | O(n)        |
| Space        | O(n)        |

---

## Why Manacher's is Better than Expand Around Center

| Approach                   | Time Complexity |
|---------------------------|-----------------|
| Expand Around Center      | O(n²)           |
| Manacher's Algorithm      | O(n)            |

While Expand Around Center is simpler, it ends up expanding multiple times over the same sections. Manacher avoids that by using mirror values and smart boundary tracking.

---

## Visualization Table (for "abba")

| i | Char | Mirror | p[i] | center | right |
|---|------|--------|------|--------|-------|
| 1 | #    | -      | 0    | -      | -     |
| 2 | a    | 0      | 1    | 2      | 3     |
| 3 | #    | 1      | 0    |        |       |
| 4 | b    | 0      | 1    | 4      | 5     |
| 5 | #    | 3      | 4    | 5      | 9     |
| 6 | b    | 4      | 1    |        |       |
| 7 | #    | 3      | 0    |        |       |

---

## Conclusion

Manacher’s algorithm is the optimal approach to solve the Longest Palindromic Substring problem in linear time by transforming the input string and leveraging symmetry around palindrome centers.