# Add Two Numbers – Solution Explanation

## Problem Summary

You are given two non-empty linked lists representing two non-negative integers.  
The digits are stored in **reverse order**, and each of their nodes contains a single digit.  
Add the two numbers and return the result as a linked list, also in reverse order.

---

## Approach: Iterative with Carry Handling

We simulate the digit-by-digit addition, similar to how you add numbers manually from right to left:

1. Traverse both linked lists simultaneously.
2. Add corresponding digits along with any carry from the previous step.
3. Create a new node for the result digit (`sum % 10`).
4. Update the carry (`sum / 10`).
5. Continue until all digits and carry are processed.

We use a **dummy head** node to simplify handling of the result list.

---

## Example Walkthrough

**Input:**
- l1 = [2, 4, 3] → represents 342
- l2 = [5, 6, 4] → represents 465


**Expected Output:**
- [7, 0, 8] → represents 807


### Step-by-step Breakdown:

| Step | l1 Node | l2 Node | Carry | Sum            | New Digit | New Carry | Result List |
|------|---------|---------|-------|----------------|-----------|-----------|-------------|
| 1    | 2       | 5       | 0     | 2 + 5 + 0 = 7  | 7         | 0         | 7           |
| 2    | 4       | 6       | 0     | 4 + 6 + 0 = 10 | 0         | 1         | 7 → 0       |
| 3    | 3       | 4       | 1     | 3 + 4 + 1 = 8  | 8         | 0         | 7 → 0 → 8   |

### Final Linked List:
- 7 → 0 → 8


---

## Time & Space Complexity

### Time Complexity: `O(max(m, n))`
- We iterate through both lists once.
- m = number of nodes in `l1`, n = number of nodes in `l2`.

### Space Complexity: `O(max(m, n) + 1)`
- We create a new list to store the result.
- Extra space is used only for the output list (not counting input lists).
- `+1` accounts for possible carry at the end (e.g., 999 + 1 = 1000).

---

## Why Not Use a Naive Approach?

A naive approach might:
- Convert the linked list to integer
- Perform integer addition
- Convert the result back to a linked list

However:
- This doesn’t work for very large numbers (overflows).
- Violates the constraint of not using extra conversions.
- Inefficient and loses the point of the linked list representation.

---

## Edge Cases to Consider

- Lists of unequal lengths.
- Final carry-over (e.g., 5 + 5 = 10).
- One of the lists is empty.
- Both lists contain only `0`.

---

## Summary

This problem is a perfect example of how we simulate arithmetic logic using a data structure like a linked list.  
Using a dummy head and careful carry tracking keeps the implementation clean and efficient.
