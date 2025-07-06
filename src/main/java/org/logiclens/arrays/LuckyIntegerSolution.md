# Lucky Integer – Solution Explanation

## Problem Summary

Given an array of integers `arr`, a lucky integer is defined as an integer whose value is equal to its frequency in the array.

The task is to return the **largest lucky integer**. If no such number exists, return `-1`.

---

## Approach – Frequency Array (Optimized for Constraints)

### Step 1: Count Frequencies
Since all values are in the range `1` to `500`, we use a fixed-size array `freq[500]` to count how many times each number appears.

- For each number `num` in `arr`, we increment `freq[num - 1]`.

### Step 2: Optional Optimization – Track Min and Max
Although **not necessary**, you may optionally track the minimum and maximum values from the array to reduce the range you need to scan in the final step. This is useful only when the range is very large.

However, for this specific problem, the range is small and bounded (`≤ 500`), so a full scan is acceptable and clearer.

### Step 3: Scan for the Largest Lucky Integer
Iterate from index `499` down to `0`. For each index `i`, check:
- If `freq[i] == i + 1`, then `i + 1` is a lucky integer.

Return the first such value found (this will be the **largest** lucky integer). If none is found, return `-1`.

---

## Time and Space Complexity

### Time Complexity: O(n)
- One pass to build the frequency array: O(n)
- One pass to scan for lucky number (at most 500): O(1) in practice
- Total: **O(n)**

### Space Complexity: O(1)
- The frequency array is fixed-size (500 elements), regardless of input size

---

## Comparison with Alternatives

| Method                   | Time   | Space | Description                             |
|--------------------------|--------|-------|-----------------------------------------|
| Frequency Array (this)   | O(n)   | O(1)  | Fastest and simplest within constraints |
| HashMap Frequency Count  | O(n)   | O(n)  | General-purpose, works beyond 500 range |
| Java 8 Stream-based      | O(n)   | O(n)  | Concise, less performant                |

---

## Summary

This approach is highly efficient due to:
- Use of a fixed-size frequency array
- Constant-time frequency lookups
- Scanning in reverse to find the largest valid result

Tracking `min` and `max` is optional and does not offer measurable benefits for this problem. The solution is already optimal for both time and space.
