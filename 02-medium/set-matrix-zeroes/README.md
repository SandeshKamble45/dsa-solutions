# Set Matrix Zeroes

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Matrix &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/set-matrix-zeroes)

## Problem

If an element in an m x n matrix is 0, set its entire row and column to 0 — in place.

## Approach

Use the first row and first column of the matrix itself as marker arrays for which rows/columns need zeroing, with two separate booleans tracking whether the first row/column itself needs to be zeroed.

## Gotchas / Edge Cases

- Scan and mark *before* you start zeroing, or you'll cascade zero the whole matrix.
- Handle the first row/column's own zero-flag last so you don't clobber your markers early.

## Complexity

- **Time:** O(mn)
- **Space:** O(1) extra

## Solution

```java
class Solution {


      public void setZeroes(int[][] mat) {
          int m = mat.length;
          int n = mat[0].length;

          int[] rows = new int[m];
          int[] cols = new int[n];

          for(int i = 0; i< m; i++){


               for(int j = 0 ; j < n ; j++){
                   if(mat[i][j] == 0){
                       rows[i] = 1;
                       cols[j] = 1;
                   }
               }
          }

              for(int i = 0; i< m; i++){
                for(int j = 0 ; j < n ; j++){
                    if(rows[i] == 1 || cols[j] == 1){
                        mat[i][j] = 0;
                    }
                }
          }


      }
}
```
