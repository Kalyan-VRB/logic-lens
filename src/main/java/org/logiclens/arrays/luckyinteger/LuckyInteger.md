# Lucky Integer in an Array

## Problem Statement

Given an array of integers `arr`, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer, return `-1`.

---

## Examples

### Example 1
Input:  
`arr = [2, 2, 3, 4]`  
Output:  
`2`  
Explanation:  
The only lucky number is `2` because its frequency is `2`.

---

### Example 2
Input:  
`arr = [1, 2, 2, 3, 3, 3]`  
Output:  
`3`  
Explanation:  
1 appears once, 2 appears twice, and 3 appears three times. All are lucky; the largest is `3`.

---

### Example 3
Input:  
`arr = [2, 2, 2, 3, 3]`  
Output:  
`-1`  
Explanation:  
No integer appears a number of times equal to its value.

---

## Constraints

- `1 <= arr.length <= 500`
- `1 <= arr[i] <= 500`

---

## Goal

Identify all integers whose frequency equals their value and return the largest one among them. Return `-1` if none exist.

---
## 🔗 Related Resources

- [Solution Explanation](LuckyIntegerSolution.md)
- [Java Code](LuckyInteger.java)
- [Test Cases](LuckyIntegerTest.java)

---