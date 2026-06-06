# Two Sum

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Array, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/two-sum)

## Problem

Given an array of integers and a target, return the indices of the two numbers that add up to the target.

## Approach

Walk the array once while keeping a hash map of `value -> index` for everything seen so far. At each element, check whether `target - current` already exists in the map; if it does, you've found your pair.

## Gotchas / Edge Cases

- Don't reuse the same element twice.
- Return indices, not values.
- Works even with duplicate values since you check *before* inserting the current element.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[2];
        for(int i = 0; i< n; i++ ){
            int preValue = target - nums[i];
            if(map.containsKey(preValue)){
                 ans[0] = map.get(preValue);
                 ans[1] = i;
                 break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
```
