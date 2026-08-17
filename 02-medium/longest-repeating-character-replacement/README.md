# Longest Repeating Character Replacement

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Sliding Window &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/longest-repeating-character-replacement)

## Problem

Find the length of the longest substring you can get by replacing at most k characters with any other character, so all characters match.

## Approach

Sliding window with a 26-letter frequency count. Expand the window each step; if `windowLength - mostFrequentCharCount > k`, shrink from the left.

## Gotchas / Edge Cases

- You don't need to accurately decrement `maxFreq` when shrinking — the window only ever grows in total size over the run, so the final answer stays correct even with a slightly stale max.

## Complexity

- **Time:** O(n)
- **Space:** O(1) (fixed 26-letter alphabet)

## Solution

```java
class Solution {

      public int findMax(int[] arr){
          int max = 0;

          for(int num : arr){
            max = Math.max(max, num);
          }
          return max;
      }

      public int characterReplacement(String s, int k) {
          int maxLen = Integer.MIN_VALUE;
          int[] map = new int[26];
          int l = 0; int r = 0;
          int n = s.length();
          while(r < n ){
              int cr = s.charAt(r);
              map[cr - 'A']++;
              int len = r - l + 1;
              int maxFreq = findMax(map);
              int extras = len - maxFreq;
              if(extras <= k){
                   maxLen = Math.max(maxLen, len);
              }else{
                   map[s.charAt(l) - 'A']--;
                   l++;
              }
              r++;
          }
          return maxLen;
      }
}
```
