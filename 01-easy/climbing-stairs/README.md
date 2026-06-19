# Climbing Stairs

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Dynamic Programming &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/climbing-stairs)

## Problem

Count the number of distinct ways to climb n stairs taking 1 or 2 steps at a time.

## Approach

This is Fibonacci in disguise: `ways(n) = ways(n-1) + ways(n-2)`, because the last step taken was either a single step from n-1 or a double step from n-2.

## Gotchas / Edge Cases

- Base cases: `ways(0) = 1`, `ways(1) = 1` — easy to get these swapped.
- Can be optimized from O(n) to O(1) space by keeping only the last two values.

## Complexity

- **Time:** O(n)
- **Space:** O(1) optimized

## Solution

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

          int[] dp = new int[n + 1];
          dp[1] = 1;
          dp[2] = 2;

          for (int i = 3; i <= n; i++) {
              dp[i] = dp[i - 1] + dp[i - 2];
          }

          return dp[n];
      }
}
```
