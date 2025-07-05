# Container With Most Water

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of
the ith line are:

- (i, 0) and
- (i, height[i])

Find two lines that, together with the x-axis, form a container such that the container holds the **most water**.

Return the **maximum amount of water** a container can store.

Note: The container cannot be slanted; it must be formed by two vertical lines and the x-axis.

---

## Examples

### Example 1

**Input:**  
`height = [1,8,6,2,5,4,8,3,7]`

**Output:**  
`49`

**Explanation:**  

The vertical lines are represented by the array. Choosing the lines at index 1 (height = 8) and index 8 (height = 7),
the container has width = 8 - 1 = 7 and height = min(8, 7) = 7. So, area = 7 * 7 = 49.
---

### Example 2

**Input:**  
`height = [1,1]`

**Output:**  
`1`

**Explanation:**  
Only two lines with height 1 each. Distance between them is 1. So area = 1 * 1 = 1.

---

## Constraints

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

---

## Objective

Determine the maximum area that can be formed between any two vertical lines and the x-axis.

---

## 🔗 Related Resources

- [Solution Explanation](ContainerWithMostWaterSolution.md)
- [Java Code](ContainerWithMostWater.java)
- [Test Cases](ContainerWithMostWaterTest.java)

---
