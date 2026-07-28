# Subsets

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Backtracking &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/subsets)

## Problem

Generate the power set — all possible subsets — of a list of distinct integers.

## Approach

Backtracking where, at each recursive call, you first add the current path as a valid subset, then try extending it with each remaining candidate in turn.

## Gotchas / Edge Cases

- Every recursive call represents a valid subset, not just leaf calls — add the current path to results at the top of each call, not only at the deepest point.

## Complexity

- **Time:** O(n * 2^n)
- **Space:** O(n) recursion depth

## Solution

```java
class Solution {
    public void dfs(int i, int[] nums, List<Integer> temp,      List<List<Integer>> ans){
        int n = nums.length;
        if(i == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(i+1, nums, temp, ans);
        temp.remove(temp.size() -1);
        dfs(i+1, nums, temp, ans);
    }

      public List<List<Integer>> subsets(int[] nums) {
          List<Integer> temp = new ArrayList<>();
          List<List<Integer>> ans = new ArrayList<>();
          dfs(0, nums, temp, ans);
          return ans;
      }
}
```
