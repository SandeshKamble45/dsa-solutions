# Container With Most Water

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Two Pointers &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/container-with-most-water)

## Problem

Given heights of vertical lines, find two lines that together with the x-axis form the container holding the most water.

## Approach

Two pointers starting at both ends. At each step, the shorter line is the bottleneck, so move that pointer inward — moving the taller one can never improve the area.

## Gotchas / Edge Cases

- Area = `min(height[l], height[r]) * (r - l)` — always governed by the shorter side.
- Moving the taller pointer first is a common but incorrect instinct.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int l = 0; int r = n-1;
        int max = 0;
        while(l <= r){
            max = Math.max(max, Math.min(nums[l], nums[r]) * (r - l));
            if(nums[l] < nums[r]){
                 l++;
            }else{
                 r--;
            }
        }
    return max;
    }
}
```
