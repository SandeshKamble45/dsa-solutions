# Word Search

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Backtracking, DFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/word-search)

## Problem

Determine whether a given word can be constructed from adjacent (4-directional) letters in a grid, without reusing a cell.

## Approach

Backtracking DFS from every cell matching the word's first letter. Temporarily mark a cell visited before recursing into neighbors, and restore it on backtrack so other paths can use it.

## Gotchas / Edge Cases

- You *must* unmark the cell after exploring — forgetting this is the single most common bug.
- Bounds-check and letter-match before every recursive call to prune early.

## Complexity

- **Time:** O(mn * 4^L), L = word length
- **Space:** O(L) recursion stack

## Solution

```java
class Solution {

      public boolean dfs(int i, int j , int ind,    char[][] board,String word){
          int m = board.length;
          int n = board[0].length;

          if( ind == word.length()){
              return true;
          }

          if(i < 0 || j < 0 || i >= m || j >=n ) return false;
          char ch = board[i][j];
          if(board[i][j] == '*') return false;

          if(board[i][j] != word.charAt(ind)){
              return false;
          }

          board[i][j] = '*';
          boolean result =
          dfs(i-1, j, ind+1, board, word) ||
          dfs(i+1, j, ind+1, board, word) ||
          dfs(i, j-1, ind+1, board, word) ||
          dfs(i, j+1, ind+1, board, word) ;

          board[i][j] = ch ;


          return result;

      }

      public boolean exist(char[][] board, String word) {
          int m = board.length;
          int n = board[0].length;
          for(int i = 0; i< m; i++){
              for(int j = 0; j < n; j++){
                  if(board[i][j] == word.charAt(0)){
                      if( dfs(i, j , 0, board, word) ){
                          return true;
                      }
                  }
              }
          }
          return false;
      }
}
```
