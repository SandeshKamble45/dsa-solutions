# Search a 2D Matrix

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Binary Search, Matrix &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/search-a-2d-matrix)

## Problem

Search for a target in a matrix where each row is sorted and the first element of each row exceeds the last element of the previous row.

## Approach

Treat the matrix as one big sorted array conceptually, and binary search over indices `0..(m*n-1)`, converting `mid` to `(mid / cols, mid % cols)` to read the actual value.

## Gotchas / Edge Cases

- The row/column conversion (`mid / cols`, `mid % cols`) is the only tricky part — get it backward and the search silently returns wrong results.

## Complexity

- **Time:** O(log(mn))
- **Space:** O(1)

## Solution

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0; int high = n * m - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / m; int col = mid % m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
```
