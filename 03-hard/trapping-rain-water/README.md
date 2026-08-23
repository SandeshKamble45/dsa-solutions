# Trapping Rain Water

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Array, Two Pointers &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/trapping-rain-water)

## Problem

Given elevation heights, compute the total water trapped between bars after it rains.

## Approach

Two pointers from both ends, tracking `leftMax` and `rightMax`. Move whichever pointer has the smaller max inward, since that side is the limiting bound for water level at that position.

## Gotchas / Edge Cases

- Water trapped at any position is `min(leftMax, rightMax) - height[i]`, and is never negative by construction of the algorithm.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int trap(int[] ht) {
        int n = ht.length;
        int low = 0; int high = n - 1;
        int lmax = 0; int rmax = 0; int count = 0;
        while(low <= high){
            lmax = Math.max(lmax, ht[low]);
            rmax = Math.max(rmax, ht[high]);
            if(lmax <= rmax){
                 count += lmax - ht[low];
                 low++;
            }else{
                 count += rmax - ht[high];
                 high--;
            }
        }
        return count;
    }
}
```
