# Maximum Subarray

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Dynamic Programming (Kadane's) &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/maximum-subarray)

## Problem

Find the contiguous subarray with the largest sum.

## Approach

Kadane's algorithm: keep a running sum; whenever it drops below the current element's value alone, reset it to just that element (i.e. `curr = max(curr + x, x)`), tracking the best sum seen.

## Gotchas / Edge Cases

- The array can be all negative — the answer still must include at least one element (the least negative one).

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i< n; i++){
          currSum = Math.max(currSum + nums[i], nums[i]);
          max = Math.max(max, currSum);
        }
        return max;
    }
}
```
