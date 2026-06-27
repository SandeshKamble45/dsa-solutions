# Longest Substring Without Repeating Characters

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Sliding Window, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters)

## Problem

Find the length of the longest substring without any repeating characters.

## Approach

Sliding window with a HashMap storing each character's most recent index. When you hit a repeat within the current window, jump the left pointer to just past that character's last occurrence.

## Gotchas / Edge Cases

- The left pointer should only ever move forward — take `Math.max(left, lastIndex+1)` rather than jumping unconditionally, or you can move it backward incorrectly.

## Complexity

- **Time:** O(n)
- **Space:** O(min(n, charset size))

## Solution

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int n = s.length();
        int l = 0; int r = 0;
        int maxC = 0;
        while(r < n){
           char ch = s.charAt(r);
           while(map[ch] == 1){
             map[s.charAt(l)] = 0;
             l++;
           }
             map[ch] = 1;
             maxC = Math.max(maxC, r - l + 1);
             r++;
        }
        return maxC;
    }
}
```
