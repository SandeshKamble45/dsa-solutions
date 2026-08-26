# Minimum Window Substring

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Sliding Window &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/minimum-window-substring)

## Problem

Find the smallest substring of s that contains every character of t (respecting character counts).

## Approach

Sliding window with two pointers and a frequency map of t's characters. Expand the right pointer until the window is "valid" (contains all required characters/counts), then shrink from the left while it remains valid, tracking the smallest valid window seen.

## Gotchas / Edge Cases

- Track a single "how many required unique characters are currently satisfied" counter rather than comparing full frequency maps each time — this keeps each window check O(1) instead of O(alphabet size).

## Complexity

- **Time:** O(|s| + |t|)
- **Space:** O(|s| + |t|)

## Solution

```java
class Solution {

      public String minWindow(String s, String t) {

          int freq[] = new int[128];
          for(char ch : t.toCharArray()){
              freq[ch]++;
          }
          int m = s.length();
          int n = t.length();
          int l = 0 ; int r = 0; int count = 0;int minLen = Integer.MAX_VALUE;
          String ans = ""; int sInd = -1;
          while(r < m){
              if( freq[s.charAt(r)] > 0 ){
                  count++;
              }
              freq[s.charAt(r)]--;
              while(count == n){
                if( r - l + 1 < minLen ){
                  minLen = r - l + 1;
                  sInd = l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l++)] > 0){
                  count--;
                }
              }
              r = r + 1;
          }

          if(sInd == -1){
              return "";
          }else{
              return s.substring(sInd,sInd + minLen);
          }
      }
}
```
