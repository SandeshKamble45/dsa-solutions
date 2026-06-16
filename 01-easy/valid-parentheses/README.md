# Valid Parentheses

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Stack &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/valid-parentheses)

## Problem

Check whether a string of brackets `()[]{}` is well-formed.

## Approach

Push opening brackets onto a stack. On a closing bracket, check the stack top matches the expected opener and pop; if it doesn't match (or the stack is empty), the string is invalid.

## Gotchas / Edge Cases

- An empty stack when you hit a closing bracket means invalid — don't skip that check.
- The stack must be exactly empty at the end, not just "not full of mismatches".

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                 stack.push(s.charAt(i));
            }else{
                   if(stack.isEmpty()) return false;
                 char ch = stack.pop();
                 if(ch == '(' && s.charAt(i) == ')' || ch == '{' && s.charAt(i) == '}' || c
                      continue;
                 }else{
                      return false;
                 }

              }
           }
          return stack.isEmpty();
      }
}
```
