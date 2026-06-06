# Contains Duplicate

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Array, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/contains-duplicate)

## Problem

Return true if any value appears at least twice in the array.

## Approach

Insert elements into a HashSet one at a time; if an insertion fails because the value is already present, you've found a duplicate.

## Gotchas / Edge Cases

- Sorting first and checking adjacent elements is an O(n log n)/O(1) alternative if extra space is a concern.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i< n-1; i++){
            if(nums[i+1] == nums[i]){
                 return true;
            }
        }

          return false;
      }
}
```
