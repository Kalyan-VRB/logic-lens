# Median of Two Sorted Arrays – Solution Explanation

## Problem Summary

Given two sorted arrays `nums1` and `nums2` of sizes `m` and `n`, find the median of the two arrays. The combined runtime complexity must be O(log (m + n)).

---

## Why Not Use Brute Force?

A brute-force approach would merge the two arrays and directly pick the median:

1. Merge `nums1` and `nums2` into a sorted array of length `m + n` — O(m + n)
2. Find the middle element(s) and compute the median — O(1)

**Time Complexity:** O(m + n)  
This does not meet the problem's required time complexity of O(log (m + n)).

---

## Optimal Approach – Binary Search on Partition

To achieve logarithmic time complexity, we avoid merging and instead use **binary search** on the smaller array to find the correct **partition point** in both arrays. The goal is to divide the arrays such that:

- The total number of elements in the left and right halves is balanced
- The maximum element on the left side is less than or equal to the minimum element on the right side

We always perform binary search on the smaller array to keep time complexity logarithmic.

---

## Step-by-Step Algorithm

1. **Identify smaller array.**  
   If `nums1.length > nums2.length`, swap them so binary search is always on the smaller array.

2. **Binary search setup.**  
   Define `low = 0`, `high = m`, and `left = (m + n + 1) / 2` (number of elements in the left half).

3. **Partition both arrays.**  
   At each step:
   - `mid1 = (low + high) / 2` → partition of `nums1`
   - `mid2 = left - mid1` → corresponding partition of `nums2`

4. **Define boundary values.**
   - `l1 = nums1[mid1 - 1]` if mid1 > 0, else -∞
   - `r1 = nums1[mid1]` if mid1 < m, else +∞
   - `l2 = nums2[mid2 - 1]` if mid2 > 0, else -∞
   - `r2 = nums2[mid2]` if mid2 < n, else +∞

5. **Check valid partition.**
   - If `l1 <= r2` and `l2 <= r1`, we found the correct partition.
      - If total length is even, median = average of max(l1, l2) and min(r1, r2)
      - If odd, median = max(l1, l2)

6. **Adjust search.**
   - If `l1 > r2`, move left: `high = mid1 - 1`
   - If `l2 > r1`, move right: `low = mid1 + 1`

7. **If no partition found, throw exception.**

---

## Edge Cases Handled

- One of the arrays is empty
- Arrays of unequal sizes
- Negative numbers or duplicates
- Odd and even total lengths
- Invalid input (both arrays empty)

---

## Time Complexity

- **O(log(min(m, n)))**: We perform binary search only on the smaller array.

## Space Complexity

- **O(1)**: No extra space is used except for a few variables.

---

## Summary

This approach leverages the sorted property of the input arrays and uses binary search to find the correct partition without merging. It guarantees logarithmic performance and is optimal for this problem. This is a classic example of applying binary search to a non-traditional problem.
