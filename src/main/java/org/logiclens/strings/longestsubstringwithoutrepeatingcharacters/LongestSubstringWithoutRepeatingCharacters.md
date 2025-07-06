# Longest Substring Without Repeating Characters

## Problem Statement

Given a string `s`, find the **length of the longest substring** without repeating characters.

A **substring** is a contiguous sequence of characters within the string.  
Characters must not repeat — if a character is repeated, the substring ends before the repetition.

---

## Examples

### Example 1:
**Input:**  
`s = "abcabcbb"`  
**Output:**  
`3`  
**Explanation:**  
The longest substring without repeating characters is `"abc"`, which has a length of 3.

---

### Example 2:
**Input:**  
`s = "bbbbb"`  
**Output:**  
`1`  
**Explanation:**  
The longest substring without repeating characters is `"b"`.

---

### Example 3:
**Input:**  
`s = "pwwkew"`  
**Output:**  
`3`  
**Explanation:**  
The longest substring without repeating characters is `"wke"`.  
Note: `"pwke"` is not valid since `"k"` comes after a repeating `"w"`, and they are not contiguous.

---

## Constraints

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

---

## Clarifications

- A **substring** must be continuous; a **subsequence** does not need to be.
- Return only the **length** of the longest valid substring, not the substring itself.
- The input may include spaces, symbols, or digits.

---

## 🔗 Related Resources

- [Solution Explanation](LongestSubstringWithoutRepeatingCharactersSolution.md)
- [Java Code](LongestSubstringWithoutRepeatingCharacters.java)
- [Test Cases](LongestSubstringWithoutRepeatingCharactersTest.java)

---