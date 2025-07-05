# Container With Most Water – Solution Explanation

## Problem Overview

Given an array of non-negative integers representing vertical line heights, the task is to find two lines that, along with the x-axis, form a container that holds the most water.

The area of water between any two lines is determined by:
- The **distance** between the two lines (width)
- The **shorter** of the two lines (height)

The goal is to maximize this area.

---

## Why Brute Force is Inefficient

A brute-force approach would involve:
- Checking all pairs of lines
- Calculating area for each pair
- Keeping track of the maximum area

This leads to a **time complexity of O(n²)**, which is not efficient for large input sizes.

---

## Optimal Approach – Two Pointer Technique

### Key Insight

To improve efficiency, we use a **two-pointer strategy**:
- Start with one pointer at the beginning and one at the end of the array
- The area between them depends on the shorter line
- To maximize area, we need to consider:
    - Moving the pointer that points to the shorter line inward
    - This is because moving the taller one would only reduce the width without increasing the height

By doing this iteratively, we explore all possible containers where one of the lines is shorter — without checking every pair explicitly.

---

## Step-by-Step Logic

1. Initialize two pointers at both ends of the array.
2. Compute the area formed by the lines they point to.
3. Move the pointer at the shorter line inward (since moving the taller one won't help increase area).
4. Keep updating the maximum area found so far.
5. Repeat until the two pointers meet.

---

## Time and Space Complexity

- **Time Complexity:** O(n)
    - Each line is considered at most once.
- **Space Complexity:** O(1)
    - Only a few integer variables are used for tracking.

---

## Brute Force vs Optimal (Two-Pointer) Comparison

| Aspect                 | Brute Force                              | Two-Pointer (Optimal)               |
|------------------------|-------------------------------------------|-------------------------------------|
| **Time Complexity**    | O(n²)                                     | O(n)                                |
| **Space Complexity**   | O(1)                                      | O(1)                                |
| **Method**             | Check every pair of lines                 | Start from ends, move inward        |
| **When to Use**        | Educational or for small input sizes      | Always use for production/interview |
| **Key Weakness**       | Inefficient for large input sizes         | None (proven optimal)               |
| **Key Insight Missed** | Doesn't leverage sorted positions         | Greedily skips non-promising pairs  |

---

## Summary

This two-pointer approach is both **efficient** and **intuitive**, making it the optimal solution for this problem. It avoids unnecessary comparisons and reaches the maximum area in a single pass through the array.
