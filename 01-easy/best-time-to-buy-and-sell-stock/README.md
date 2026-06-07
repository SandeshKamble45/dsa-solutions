# Best Time to Buy and Sell Stock

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Array, Greedy &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)

## Problem

Given daily prices and a single allowed buy/sell transaction, find the maximum profit.

## Approach

Track the minimum price seen so far while scanning left to right. At each day, compute the profit if you sold today (`price - minSoFar`) and keep the running maximum.

## Gotchas / Edge Cases

- You must buy before you sell — never let sell-day precede buy-day.
- If prices only fall, the answer is 0, not negative.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int min = nums[0];
        int maxProfit = 0;
        for(int i = 1; i< n; i++){
            if(nums[i] < min){
                 min = nums[i];
            }
            maxProfit = Math.max(maxProfit, nums[i] - min);
        }

          return maxProfit;
      }
}
```
