# Median of Two Sorted Arrays

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Binary Search &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/median-of-two-sorted-arrays)

## Problem

Find the median of two sorted arrays in O(log(min(m, n))) time.

## Approach

Binary search on the partition point of the *smaller* array. For each candidate partition, compute the corresponding partition of the other array such that the combined left half has exactly half the total elements, then check whether the boundary values satisfy the median property.

## Gotchas / Edge Cases

- Use sentinel values (±infinity) for out-of-bounds partition edges.
- Handle even vs. odd total length separately when computing the final median from the boundary values.

## Complexity

- **Time:** O(log(min(m, n)))
- **Space:** O(1)

## Solution

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if( n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0; int high = n1;
        int left = (n1 + n2 + 1)/2 ;
        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE; int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE; int r2 = Integer.MAX_VALUE;
            if(mid1 > 0) l1 = nums1[mid1 - 1];
            if(mid2 > 0) l2 = nums2[mid2 - 1];
            if(mid1 < n1 ) r1 = nums1[mid1];
            if(mid2 < n2 ) r2 = nums2[mid2];
            if( l1 <= r2 && l2 <= r1 ) {
                 if( (n1 + n2) % 2 == 0){
                     return ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0) ;
                 }else{
                     return Math.max(l1, l2);
                 }
            }else if( l1 > r2 ){
                 high = mid1 - 1;
            }else{
                 low = mid1 + 1;
            }

          }
          return 0.0;
      }
}
```
