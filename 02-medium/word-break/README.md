# Word Break

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Dynamic Programming &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/word-break)

## Problem

Determine whether a string can be segmented into a space-separated sequence of one or more dictionary words.

## Approach

DP where `dp[i]` means "the first i characters can be segmented." For each `i`, check all `j < i` where `dp[j]` is true and `s[j:i]` is in the dictionary.

## Gotchas / Edge Cases

- Use a HashSet for the dictionary for O(1) lookups — a List/array lookup makes this quadratic-times-slower for no reason.

## Complexity

- **Time:** O(n^2) (plus substring cost)
- **Space:** O(n)

## Solution

```java
class Solution {

      public boolean findWord(int i, String s, List<String> dict, Boolean[] memo){
          if(i == s.length()){
              return true;
          }
          if(memo[i] != null) return memo[i];
          for( String w : dict){
              int len = i + w.length();
              if( len <= s.length()){
                  if(s.substring(i, len).equals(w)){
                      if(findWord(len,s, dict, memo)){
                           memo[i] = true;
                           return true;
                      }
                  }
              }
          }
          memo[i] = false;
          return false;
      }

      public boolean wordBreak(String s, List<String> wordDict) {
          Boolean[] memo = new Boolean[s.length() + 1];
         return findWord(0, s, wordDict, memo);
      }
}
```
