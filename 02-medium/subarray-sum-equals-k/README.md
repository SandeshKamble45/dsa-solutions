# Subarray Sum Equals K

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Prefix Sum, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/subarray-sum-equals-k)

## Problem

Count the number of contiguous subarrays whose elements sum to k.

## Approach

Maintain a running prefix sum and a HashMap of `prefixSum -> frequency`. At each index, check how many times `prefixSum - k` has occurred before — each such occurrence marks a valid subarray ending here.

## Gotchas / Edge Cases

- Initialize the map with `{0: 1}` up front to correctly count subarrays that start at index 0.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); int preSum = 0;
        for(int i = 0 ; i < n; i++){
            preSum += nums[i];
            int x = preSum - k;
            if(map.containsKey(x)){
                 count += map.get(x);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1 );
        }
        return count;
    }
}
```
