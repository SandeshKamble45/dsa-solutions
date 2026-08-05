# Number of Islands

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Graph, DFS/BFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/number-of-islands)

## Problem

Count the number of islands (groups of '1's connected 4-directionally) in a 2D grid.

## Approach

Scan every cell; whenever you find an unvisited '1', increment the island count and DFS/BFS outward, marking every connected '1' as visited so it isn't counted again.

## Gotchas / Edge Cases

- Mark cells visited in place (or with a visited array) — otherwise you'll recount parts of the same island.
- Always bounds-check before recursing into a neighbor.

## Complexity

- **Time:** O(mn)
- **Space:** O(mn) worst-case recursion stack

## Solution

```java
class Solution {

      static class Pair{
          int row;
          int col;

          Pair(int row, int col){
              this.row = row;
              this.col = col;
          }
      }

      public void bfs(int row, int col , char[][] grid){
          grid[row][col] = '0';
          int m = grid.length;
          int n = grid[0].length;
          Queue<Pair> q = new ArrayDeque<>();
          q.offer(new Pair(row, col));
          int[] dRow = {-1, 0, 1, 0};
          int[] dCol = {0, 1, 0, -1};

          while( !q.isEmpty() ){
              Pair curr = q.poll();
              int currRow = curr.row;
              int currCol = curr.col;
              for(int i = 0 ; i < 4 ; i++){
                      int newRow = currRow + dRow[i];
                      int newCol = currCol + dCol[i];
                      if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                          && grid[newRow][newCol] == '1' ){
                             grid[newRow][newCol] = '0';
                              q.offer(new Pair(newRow, newCol));
                      }
              }
          }
      }


      public int numIslands(char[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          int count = 0;

          for(int row = 0; row < m; row++){
              for(int col = 0; col < n ; col++){
                  if(grid[row][col] == '1'){
                      count++;
                      bfs(row, col, grid);
                  }
              }
          }

          return count;
      }
}
```
