# Longest Consecutive Sequence

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/longest-consecutive-sequence)

## Problem

Find the length of the longest run of consecutive integers in an unsorted array, in O(n).

## Approach

Put every number in a HashSet. For each number that is the *start* of a sequence (i.e. `num - 1` is not in the set), count upward (`num+1`, `num+2`, ...) to find that sequence's length.

## Gotchas / Edge Cases

- The "is this a sequence start" check is what keeps this O(n) overall — without it you'd re-count the same run from every element inside it, degrading to O(n^2).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0 ) return 0;
       Arrays.sort(arr);
        int count = 1, maxCount = 1;
        for(int i = 1; i< arr.length ; i++){
            if(arr[i - 1] == arr[i]){
                 continue;
            }else if( arr[i] - 1 == arr[i - 1]){
                 count++;
            }else{
                 count = 1;
            }
            maxCount = Math.max(count, maxCount);
        }

          return maxCount ;
      }
}
```
