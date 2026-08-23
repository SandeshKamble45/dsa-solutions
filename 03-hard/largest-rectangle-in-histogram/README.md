# Largest Rectangle in Histogram

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Monotonic Stack &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/largest-rectangle-in-histogram)

## Problem

Given bar heights forming a histogram, find the area of the largest rectangle that fits within the histogram's outline.

## Approach

Maintain a monotonically increasing stack of bar indices. When a shorter bar appears, pop taller bars off the stack, computing the rectangle area for each pop using the popped bar's height and a width determined by the current index and the new stack top.

## Gotchas / Edge Cases

- Append a sentinel bar of height 0 at the very end to force-flush any bars still left on the stack.
- Width for a popped bar is `currentIndex - newStackTop - 1`, not just `currentIndex - poppedIndex`.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int largestRectangleArea(int[] arr) {
        int max = 0;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< arr.length; i++){
           while(!st.isEmpty() && arr[st.peek()] >= arr[i] ){
             int top = st.pop();
             int pse = st.isEmpty() ? -1 : st.peek();
             max = Math.max(max, arr[top] * (i - pse - 1) );
           }
           st.push(i);
        }
        while( !st.isEmpty() ){
             int top = st.pop();
             int pse = st.isEmpty() ? -1 : st.peek();
             max = Math.max(max, arr[top] * (n - pse - 1)) ;
        }
        return max;
    }
}
```
