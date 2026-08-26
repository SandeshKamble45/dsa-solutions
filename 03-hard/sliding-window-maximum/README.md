# Sliding Window Maximum

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Monotonic Deque &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/sliding-window-maximum)

## Problem

Find the maximum value in every sliding window of size k as it moves across the array.

## Approach

Maintain a monotonically decreasing deque of *indices*. Before adding a new index, pop smaller elements off the back (they can never be the max while the new, larger element is in the window). Pop from the front whenever the index falls outside the current window.

## Gotchas / Edge Cases

- The front of the deque always holds the current window's maximum — but only if you remember to evict indices that have fallen out of the window's left boundary.

## Complexity

- **Time:** O(n)
- **Space:** O(k)

## Solution

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i< n; i++){
            if( !dq.isEmpty() && dq.peekFirst() <= i - k ){
                 dq.removeFirst();
            }
            while( !dq.isEmpty() && nums[dq.peekLast()] <= nums[i] ){
                 dq.removeLast();
            }
            dq.addLast(i);
            if( i >= k - 1) ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
```
