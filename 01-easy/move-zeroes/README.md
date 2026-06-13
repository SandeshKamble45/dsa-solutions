# Move Zeroes

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Array, Two Pointers &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/move-zeroes)

## Problem

Move all zeroes to the end of the array in place while preserving the relative order of non-zero elements.

## Approach

Keep a `writePointer`. Scan the array; every time you see a non-zero, place it at `writePointer` and advance. After the scan, fill everything from `writePointer` onward with zeroes.

## Gotchas / Edge Cases

- Must preserve relative order of the non-zero elements — a naive swap approach can break this if not done carefully.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {

          int n = nums.length;
          int i = 0;
          for(int j=0; j< n; j++){
              if(nums[j] != 0){
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              i++;
              }
          }

      }
}
```
