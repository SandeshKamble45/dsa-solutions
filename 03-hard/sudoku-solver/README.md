# Sudoku Solver

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Backtracking &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/sudoku-solver)

## Problem

Fill a 9x9 Sudoku board so every row, column, and 3x3 sub-box contains the digits 1-9 exactly once.

## Approach

Backtracking: for each empty cell, try digits 1-9, check row/column/box validity, place the digit and recurse if valid, and undo the placement if the recursive call fails.

## Gotchas / Edge Cases

- Maintain row/column/box "used digit" tracking structures rather than rescanning the board on every validity check — it's the difference between a solver that finishes and one that times out.

## Complexity

- **Time:** Exponential worst case, effectively fast in practice due to constraint pruning
- **Space:** O(1) extra plus recursion stack

## Solution

```java
class Solution {
    public boolean solve(char[][] bd){
        int n = bd.length;
        for(int i =0; i< n ; i++){
            for(int j = 0; j< n ; j++){
                 if(bd[i][j] == '.'){
                     for(char c = '1'; c<= '9'; c++){
                         if(isValid(i, j, c, bd)){
                             bd[i][j] = c;
                             if(solve(bd)){
                                 return true;
                             }else{
                                 bd[i][j] = '.';
                             }
                         }
                     }
                     return false;
                 }
            }
        }
        return true;
    }

      public boolean isValid(int row, int col, char c, char[][] bd){
          for(int i=0; i<9; i++){
              if(bd[row][i] == c) return false;
              if(bd[i][col] == c) return false;
              if(bd[3 * (row/3) + i/3][3 * (col/3) + i%3] == c) return false;
          }
          return true;
      }

      public void solveSudoku(char[][] bd) {
          solve(bd);
      }
}
```
