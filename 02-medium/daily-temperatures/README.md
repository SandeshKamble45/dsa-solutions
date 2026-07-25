# Daily Temperatures

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Monotonic Stack &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/daily-temperatures)

## Problem

For each day, find how many days you'd have to wait until a warmer temperature.

## Approach

Maintain a monotonically decreasing stack of *indices*. When the current temperature exceeds the temperature at the stack's top index, pop it and record the day-distance as the answer for that popped index.

## Gotchas / Edge Cases

- Store indices on the stack, not temperature values, so you can compute the distance.
- Indices left on the stack at the end never see a warmer day — leave their answer as 0.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && temp[st.peek()] < temp[i]){
                 int prev = st.pop();
                 ans[prev] = i - prev;
            }

              st.push(i);
          }
          return ans;
      }
}
```
