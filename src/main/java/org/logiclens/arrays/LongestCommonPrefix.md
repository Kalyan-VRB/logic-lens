# Longest Common Prefix

## Problem Statement

Write a function to find the **longest common prefix** string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

---

## Examples

### Example 1

**Input:**  
`strs = ["flower","flow","flight"]`

**Output:**  
`"fl"`

---

### Example 2

**Input:**  
`strs = ["dog","racecar","car"]`

**Output:**  
`""`

**Explanation:**  
There is no common prefix among the input strings.

---

## Constraints

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters if it is non-empty.

---

## Objective

Determine the longest string that is a prefix (beginning) of all strings in the array. If no such prefix exists, return an empty string.

---
## 🔗 Related Resources

- [Solution Explanation](LongestCommonPrefixSolution.md)
- [Java Code](LongestCommonPrefix.java)
- [Test Cases](LongestCommonPrefixTest.java)

---