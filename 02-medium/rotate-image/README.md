# Rotate Image

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Matrix &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/rotate-image)

## Problem

Rotate an n x n matrix 90 degrees clockwise, in place.

## Approach

Two-step trick: transpose the matrix (swap `matrix[i][j]` with `matrix[j][i]` for `i < j`), then reverse each row.

## Gotchas / Edge Cases

- Transpose only the upper triangle (`i < j`) — transposing the whole matrix naively will swap everything back.

## Complexity

- **Time:** O(n^2)
- **Space:** O(1)

## Solution

```java
class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;
        //transporse
        for(int i = 0; i< n ; i++){
            for(int j = 0 ; j < i; j++){
                 int temp = arr[i][j];
                 arr[i][j] = arr[j][i];
                 arr[j][i] = temp;
            }
        }

          // reverse
          for(int i = 0; i< n ; i++){
              int j = 0 ; int k = n-1;
              while( j < k){
                  int temp = arr[i][j];
                  arr[i][j] = arr[i][k];
                  arr[i][k] = temp;
                  j++; k--;
              }
          }
      }
}
```
