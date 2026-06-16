# Single Number

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Bit Manipulation &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/single-number)

## Problem

Every element appears exactly twice except one — find that one, in linear time and constant space.

## Approach

XOR every element together. Since `a ^ a = 0` and XOR is commutative/associative, all the paired duplicates cancel out and only the unique value survives.

## Gotchas / Edge Cases

- This trick only works because duplicates appear an even number of times — it doesn't generalize directly to "appears three times" variants.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int singleNumber(int[] nums) {

          int xor = 0;
          for(int i = 0; i < nums.length; i++){
              xor = xor ^ nums[i];
          }

          return xor;

      }
}
```
