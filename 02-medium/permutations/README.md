# Permutations

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Backtracking &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/permutations)

## Problem

Generate all possible permutations of a list of distinct integers.

## Approach

Backtracking: maintain a `used[]` boolean array; at each recursive level, try every unused number, mark it used, recurse, then unmark it (undo) before trying the next option.

## Gotchas / Edge Cases

- The unmark/undo step after each recursive call is essential — without it, later branches see a corrupted `used` state.

## Complexity

- **Time:** O(n * n!)
- **Space:** O(n) recursion depth

## Solution

```java
class Solution {

      public void dfs(int[] nums, int ind, List<List<Integer>> ans) {
          int n = nums.length;
          if (ind == n) {
              List<Integer> temp = new ArrayList<>();
              for (int i = 0; i < n; i++) {
                  temp.add(nums[i]);
              }
              ans.add(new ArrayList<>(temp));
              return;
          }

          for (int i = ind; i < n; i++) {
              swap(i , ind, nums);
              dfs(nums, ind + 1, ans);
              swap(i , ind, nums);
          }
      }

      public void swap(int i, int j , int[] nums){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }

      public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> ans = new ArrayList<>();
          int n = nums.length;
          dfs(nums, 0, ans);
          return ans;
      }
}
```
