# Jump Game

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Greedy &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/jump-game)

## Problem

Given max jump lengths at each index, determine whether you can reach the last index.

## Approach

Greedily track the farthest index reachable so far while scanning left to right. If at any point the current index exceeds the farthest reachable index, it's impossible.

## Gotchas / Edge Cases

- Update `farthest = max(farthest, i + nums[i])` at every index — don't reset it based only on the current index's jump length.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0; i< n ; i++){
              if(i > max){
                 return false;
            }
            max = Math.max(max, i + nums[i]);

          }
          return true;
      }
}
```
