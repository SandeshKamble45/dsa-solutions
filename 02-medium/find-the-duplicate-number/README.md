# Find the Duplicate Number

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Floyd's Cycle Detection &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/find-the-duplicate-number)

## Problem

An array of n+1 integers in range [1, n] has exactly one duplicate — find it without modifying the array and using O(1) extra space.

## Approach

Treat the array as an implicit linked list where `value` at index `i` points to index `nums[i]`. A duplicate value creates a cycle, which Floyd's tortoise-and-hare algorithm can locate exactly like a standard linked list cycle problem.

## Gotchas / Edge Cases

- This is the same two-phase Floyd's algorithm as Linked List Cycle II, just applied to an array-as-graph — recognizing that mapping is the key insight.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

              slow = nums[slow];
              fast = nums[nums[fast]];
          while(slow != fast){
              slow = nums[slow];
              fast = nums[nums[fast]];
          }
          slow = nums[0];
          while( slow != fast){
              slow = nums[slow];
              fast = nums[fast];
          }
          return slow;
      }
}
```
