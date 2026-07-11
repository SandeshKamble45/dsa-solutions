# Spiral Matrix

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Matrix &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/spiral-matrix)

## Problem

Return all elements of a matrix in spiral (clockwise, inward) order.

## Approach

Maintain four boundaries — top, bottom, left, right. Traverse each side in turn (top row left-to-right, right column top-to-bottom, etc.), shrinking the corresponding boundary after each side.

## Gotchas / Edge Cases

- Re-check boundary validity after each side traversal (e.g. `top <= bottom`) to avoid re-visiting or overrunning cells on single-row/column matrices.

## Complexity

- **Time:** O(mn)
- **Space:** O(1) extra

## Solution

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0 ; int right = m - 1;
        int top = 0 ; int bottom = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(left <= right && top <= bottom){
            for(int i = left ; i<= right ; i++){
            ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top ; i<=bottom; i++){
                 ans.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                 for(int i = right; i >= left ; i--){
                 ans.add(matrix[bottom][i]);
                 }
                 bottom--;
            }
            if(left <= right){
                 for(int i = bottom; i >= top ; i--){
                     ans.add(matrix[i][left]);
                 }
                 left++;
            }
        }
        return ans;
        }
    }
```
