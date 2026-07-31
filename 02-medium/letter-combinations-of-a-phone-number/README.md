# Letter Combinations of a Phone Number

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Backtracking &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number)

## Problem

Given a string of digits 2-9, return all letter combinations the number could represent on a phone keypad.

## Approach

Backtracking over the digit string, using a fixed digit-to-letters map, building up one character per recursive call and appending to results at full length.

## Gotchas / Edge Cases

- An empty input string should return an empty list — not a list containing an empty string.

## Complexity

- **Time:** O(4^n) worst case (digit 7/9 map to 4 letters)
- **Space:** O(n) recursion depth

## Solution

```java
class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

      public List<String> letterCombinations(String digits) {
          if (!digits.isEmpty()) dfs(0, digits, "");
          return res;
      }

      private void dfs(int i, String digits, String s) {
          if (i == digits.length()) {
              res.add(s);
              return;
          }
          for (char c : map[digits.charAt(i) - '0'].toCharArray())
              dfs(i + 1, digits, s + c);
      }
}
```
