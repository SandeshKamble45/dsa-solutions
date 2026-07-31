# Combination Sum

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Backtracking &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/combination-sum)

## Problem

Find all unique combinations of candidate numbers that sum to a target, where each candidate may be reused unlimited times.

## Approach

Backtracking with a `start` index: at each step either take the current candidate again (recursing without advancing the index, since reuse is allowed) or move to the next candidate.

## Gotchas / Edge Cases

- Sort candidates first so you can prune branches once the remaining target goes negative.
- Passing the same `start` index (not `start+1`) is what allows reusing a number.

## Complexity

- **Time:** O(2^t) worst case, t = target
- **Space:** O(target / min(candidates)) recursion depth

## Solution

```java
class Solution {

      public void findSum(int ind, int[] arr, int target, List<Integer> temp,
                          List<List<Integer>> ans)

      {
          int n = arr.length;

             if( target == 0){
                 ans.add(new ArrayList<>(temp));
                 return;
             }
             if(ind == n){
             return;
             }

          if(arr[ind] <= target){
              temp.add(arr[ind]);
              findSum(ind, arr, target - arr[ind], temp, ans);
              temp.remove(temp.size() - 1);
          }
          findSum(ind + 1, arr, target, temp, ans);

      }

      public List<List<Integer>> combinationSum(int[] candidates, int target) {
          List<List<Integer>> ans = new ArrayList<>();
          List<Integer> temp = new ArrayList<>();
          findSum(0, candidates, target, temp, ans);
          return ans;
      }
}
```
