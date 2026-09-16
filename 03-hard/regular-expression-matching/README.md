# Regular Expression Matching

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Dynamic Programming, String &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/regular-expression-matching)

## Problem

Implement regular expression matching supporting `.` (any single character) and `*` (zero or more of the preceding element).

## Approach

Build a 2D DP table where `dp[i][j]` means "the first i characters of s match the first j characters of p." Handle `*` specially: it can match zero occurrences (fall back to `dp[i][j-2]`) or one more occurrence of the preceding character (if it matches the current s character).

## Gotchas / Edge Cases

- The "zero occurrences" case for `*` is the one people forget — `a*` can legally match an empty string.

## Complexity

- **Time:** O(mn)
- **Space:** O(mn)

## Solution

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

          dp[0][0] = true;

          // Handle patterns like a*, a*b*, etc. matching empty string
          for (int j = 2; j <= m; j++) {
              if (p.charAt(j - 1) == '*') {
                  dp[0][j] = dp[0][j - 2];
              }
          }

          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= m; j++) {
                  char sc = s.charAt(i - 1);
                  char pc = p.charAt(j - 1);

                  if (pc == sc || pc == '.') {
                      dp[i][j] = dp[i - 1][j - 1];
                  } else if (pc == '*') {
                      // zero occurrence
                      dp[i][j] = dp[i][j - 2];

                      // one or more occurrence
                      char prev = p.charAt(j - 2);
                      if (prev == sc || prev == '.') {
                          dp[i][j] |= dp[i - 1][j];
                      }
                  }
              }
          }

          return dp[n][m];
      }
}
```
