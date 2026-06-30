# Best Time to Buy and Sell Stock II

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Greedy &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii)

## Problem

Unlimited buy/sell transactions allowed (but must sell before buying again) — maximize total profit.

## Approach

Greedily capture every positive day-over-day price increase: sum `prices[i] - prices[i-1]` whenever that difference is positive.

## Gotchas / Edge Cases

- This works because any zig-zag profit decomposes into consecutive-day gains — you don't actually need to track real buy/sell days.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int profit = 0;
      for(int i = 1; i< n; i++){
        if(prices[i] > prices[i - 1]){
            profit += prices[i] - prices[i - 1];
        }
      }
      return profit;
    }
}
```
