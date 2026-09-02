# Longest Valid Parentheses

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Stack, Dynamic Programming &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/longest-valid-parentheses)

## Problem

Find the length of the longest substring of well-formed (valid) parentheses.

## Approach

Use a stack of indices, pre-seeded with -1 as a base marker. Push the index of every `(`. On a `)`, pop the stack; if the stack becomes empty, push the current index as a new base — otherwise the current valid length is `i - stack.peek()`.

## Gotchas / Edge Cases

- The initial -1 sentinel is what makes the length formula work correctly for a valid run starting at index 0.
- Pushing a fresh base index after the stack empties out is easy to forget but essential.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        java.util.Stack<Integer> st = new java.util.Stack<>();
        st.push(-1); // base

          for (int i = 0; i < s.length(); i++) {
              if (s.charAt(i) == '(') {
                  st.push(i);
              } else {
                  st.pop();
                  if (st.isEmpty()) st.push(i);
                  else max = Math.max(max, i - st.peek());
              }
          }
          return max;
      }
}
```
