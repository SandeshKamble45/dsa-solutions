# Merge Intervals

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Sorting &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/merge-intervals)

## Problem

Given a collection of intervals, merge all overlapping ones.

## Approach

Sort intervals by start time. Walk through them, and merge the current interval into the last one in your result list whenever its start is <= the last interval's end.

## Gotchas / Edge Cases

- Sorting first is essential — without it, overlap detection in a single linear pass doesn't work.
- Compare against the *last merged* interval's end, not the original interval's.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a , b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];
        for(int i = 1; i< n; i++ ){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if( currStart <= lastEnd ){
                 lastEnd = Math.max(lastEnd, currEnd);
            }else{
                 ans.add(new int[]{lastStart, lastEnd});
                 lastStart = currStart;
                 lastEnd = currEnd;
            }
        }
        ans.add(new int[]{lastStart, lastEnd});
        return ans.toArray( new int[ans.size()][]);
    }
}
```
