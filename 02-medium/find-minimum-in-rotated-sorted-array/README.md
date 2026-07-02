# Find Minimum in Rotated Sorted Array

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Binary Search &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)

## Problem

Find the minimum element in a rotated sorted array (no duplicates) in O(log n).

## Approach

Binary search comparing `nums[mid]` to `nums[hi]`. If `nums[mid] > nums[hi]`, the minimum must be in the right half (excluding mid); otherwise it's in the left half, including mid.

## Gotchas / Edge Cases

- Loop while `lo < hi` (not `<=`), and set `hi = mid` (not `mid - 1`) in the second branch since mid could itself be the minimum.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length-1; int mid = Integer.MIN_VALUE;
        while(low <= high){
              mid = (low + high )/ 2;
            if(nums[low] <= nums[high]){
                 return nums[low];
            }
            if(nums[low] <= nums[mid]){
                 low = mid + 1;
            }else{
                 high = mid;
            }
        }
        return -1;
    }
}
```
