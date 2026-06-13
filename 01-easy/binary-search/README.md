# Binary Search

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Binary Search &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/binary-search)

## Problem

Classic textbook binary search: find a target's index in a sorted array, or -1.

## Approach

Maintain `lo`/`hi` pointers. Compute mid, compare to target, and shrink the search space by half each iteration.

## Gotchas / Edge Cases

- Use `mid = lo + (hi - lo) / 2` to avoid integer overflow on large arrays.
- Decide up front whether bounds are inclusive/exclusive and stay consistent.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if( nums[mid] == target) return mid;
            else if ( target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
```
