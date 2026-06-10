# Missing Number

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Array, Math, Bit Manipulation &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/missing-number)

## Problem

Given n distinct numbers from the range [0, n], find the one that's missing.

## Approach

Compute the expected sum `n*(n+1)/2` and subtract the actual sum of the array — the difference is the missing number. (XOR of indices and values works identically.)

## Gotchas / Edge Cases

- For very large n, use a wider integer type to avoid overflow, though it's rarely an issue at LeetCode's constraint sizes.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        int n = nums.length;

          for(int i=0; i< n; i++ ){
              xor2 = xor2 ^ nums[i];
              xor1 = xor1 ^ (i+1);
          }

          return xor1 ^ xor2;
      }
}
```
