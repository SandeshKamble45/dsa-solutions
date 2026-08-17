# Longest Palindromic Substring

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** String, Two Pointers &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/longest-palindromic-substring)

## Problem

Find the longest palindromic substring within a given string.

## Approach

For every index, expand outward in both directions (once assuming an odd-length palindrome centered there, once assuming even-length), tracking the longest palindrome found across all centers.

## Gotchas / Edge Cases

- You need both odd-center and even-center expansion calls per index — missing one silently drops valid even-length palindromes.
- A DP table is a valid O(n^2) space alternative, but expand-around-center uses only O(1) extra space.

## Complexity

- **Time:** O(n^2)
- **Space:** O(1)

## Solution

```java
class Solution {
    int start = 0, maxLen = 0;

      public String longestPalindrome(String s) {
          for (int i = 0; i < s.length(); i++) {
              expand(s, i, i);     // odd length
              expand(s, i, i + 1); // even length
          }
          return s.substring(start, start + maxLen);
      }

      private void expand(String s, int l, int r) {
          while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
              l--;
              r++;
          }

          int len = r - l - 1; // actual palindrome length

          if (len > maxLen) {
              maxLen = len;
              start = l + 1;
          }
      }
}
```
