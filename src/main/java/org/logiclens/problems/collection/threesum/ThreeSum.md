# Three Sum

## Problem Statement

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that:

- `i != j`, `i != k`, and `j != k`, and
- `nums[i] + nums[j] + nums[k] == 0`

**Note:** The solution set must **not contain duplicate triplets**.

---

## Examples

### Example 1

**Input:**
``nums = [-1, 0, 1, 2, -1, -4]``

**Output:**
``[[-1, -1, 2], [-1, 0, 1]]``

**Explanation:**
- Triplets like `(-1) + 0 + 1 = 0` and `(-1) + (-1) + 2 = 0` are valid.
- The final output excludes duplicate triplets.

---

### Example 2

**Input:**
`nums = [0, 1, 1]`


**Output:**
`[]`


**Explanation:** No combination of three numbers adds up to zero.

---

### Example 3

**Input:**
``nums = [0, 0, 0]``


**Output:**
`[[0, 0, 0]]`


**Explanation:** The only valid triplet is all zeros.

---

## Constraints

- `3 <= nums.length <= 3000`
- `-10⁵ <= nums[i] <= 10⁵`

---

## 🔗 Related Resources

- [Solution Explanation](ThreeSumSolution.md)
- [Java Code](ThreeSum.java)
- [Test Cases](ThreeSumTest.java)

---
