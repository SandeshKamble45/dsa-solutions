# Search in Rotated Sorted Array

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Binary Search &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array)

## Problem

Search for a target in a rotated (but originally sorted, no duplicates) array in O(log n).

## Approach

Modified binary search: at each step, determine which half (left or right of mid) is properly sorted, then check whether the target falls within that half's range to decide which side to continue into.

## Gotchas / Edge Cases

- Be consistent about `<=` vs `<` in your range checks — off-by-one errors here are the most common bug in this problem.

## Complexity

- **Time:** O(log n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low= 0; int high = n - 1;
        while( low <= high){
            int mid = low + (high - low)/2;
            if( nums[mid] == target){
                 return mid;
            }
            if(nums[low] <= nums[mid]){
                 if(nums[low] <= target && target <= nums[mid]){
                     high = mid - 1;
                 }else{
                     low = mid + 1;
                 }
            }else{
                 if(nums[mid] <= target && target <= nums[high]){
                     low = mid + 1;
                 }else{
                     high = mid - 1;
                 }
            }
        }
        return -1;
    }
}
```
