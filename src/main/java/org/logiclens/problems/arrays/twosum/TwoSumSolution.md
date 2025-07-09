# Two Sum – Solution Explanation

## Brute Force Approach

The brute force method involves checking every possible pair of elements in the array to determine if their sum equals the target value. For each element, we iterate through the remaining elements to find a complement that sums to the target.

Although this approach guarantees finding the solution due to the problem constraints, it is inefficient for large arrays.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)  
This is because we use two nested loops and no additional data structures.

## Optimized Approach – Hash Map

To improve efficiency, we can use a hash map to store each number as we iterate, along with its index. For each current number `num`, we compute its complement as `target - num`. If the complement is already in the hash map, we have found the pair.

This approach reduces the need to search all pairs by turning the lookup into a constant-time operation using hashing.

**Time Complexity:** O(n)  
We loop through the array only once, and each lookup or insert into the hash map takes constant time on average.

**Space Complexity:** O(n)  
We may store up to `n` elements in the hash map if no solution is found until the end.

## Key Insight

Instead of checking all combinations, we leverage the mathematical relationship between the current number and the required complement. The use of a hash map enables quick access to previously seen numbers and avoids redundant work.

## Trade-offs

While the optimized solution increases space usage, it significantly improves performance for large input sizes. In interview settings, it's common and expected to start with the brute-force idea and then optimize to this solution.

## Conclusion

The hash map approach is the most efficient and scalable solution for this problem, meeting the time complexity requirement of less than O(n²). It demonstrates both problem-solving ability and understanding of algorithmic trade-offs.
