# Unique Paths

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Dynamic Programming &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/unique-paths)

## Problem

Count the number of unique paths from the top-left to bottom-right of an m x n grid, moving only right or down.

## Approach

DP grid where `dp[i][j] = dp[i-1][j] + dp[i][j-1]`, with the entire first row and first column initialized to 1 (only one way to reach any cell on the edges).

## Gotchas / Edge Cases

- This can be compressed to a single 1D array of size `n`, updated in place row by row, for O(n) space instead of O(mn).

## Complexity

- **Time:** O(mn)
- **Space:** O(n) optimized

## Solution

```java
class Solution {

      public int path(int m , int n, int[][] dp){
          if(m < 0 || n < 0) return 0;
          if(m == 0 && n == 0) return 1;
          if(dp[m][n] != -1) return dp[m][n];
          dp[m][n] = path(m - 1, n, dp) + path(m, n-1, dp);
          return dp[m][n];
      }

      public int uniquePaths(int m, int n) {
          int[][] dp = new int[m][n];
          for(int i = 0; i< m; i++) Arrays.fill(dp[i] , -1);
          int M = m -1 ; int N = n-1;
          return path(M ,N , dp);

      }
}
```
