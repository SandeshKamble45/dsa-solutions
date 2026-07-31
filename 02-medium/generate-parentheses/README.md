# Generate Parentheses

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Backtracking &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/generate-parentheses)

## Problem

Generate all combinations of well-formed parentheses for n pairs.

## Approach

Backtracking tracking counts of `(` and `)` used so far. Add `(` whenever `open < n`; add `)` whenever `close < open` (never let closes outnumber opens).

## Gotchas / Edge Cases

- The `close < open` check is what guarantees every prefix stays valid — it's the crux of the whole solution.

## Complexity

- **Time:** O(4^n / sqrt(n)) — bounded by the nth Catalan number
- **Space:** O(n) recursion depth

## Solution

```java
class Solution {
    List<String> r = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        f("", 0, 0, n);
        return r;
    }
    void f(String s, int o, int c, int n) {
        if (s.length() == 2 * n) { r.add(s); return; }
        if (o < n) f(s + "(", o + 1, c, n);
        if (c < o) f(s + ")", o, c + 1, n);
    }
}
```
