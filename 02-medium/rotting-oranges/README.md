# Rotting Oranges

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Graph, Multi-source BFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/rotting-oranges)

## Problem

Given a grid of fresh/rotten oranges, find the minimum minutes until no fresh orange remains (or -1 if impossible).

## Approach

Multi-source BFS: seed the queue with *all* initially rotten oranges at once, then expand level by level, where each BFS level corresponds to one minute passing.

## Gotchas / Edge Cases

- Seed all rotten oranges simultaneously — running BFS from just one would give the wrong time.
- If any fresh orange is unreachable after BFS completes, return -1.

## Complexity

- **Time:** O(mn)
- **Space:** O(mn)

## Solution

```java
class Solution {
    public class Pair{
        int row;
        int col;
        int tm;

          public Pair(int row, int col, int tm){
              this.row = row;
              this.col = col;
              this.tm = tm;
          }
      }

      public int orangesRotting(int[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          Queue<Pair> q = new ArrayDeque<>();
          int tm = 0; int freshCnt = 0;
          for(int i = 0 ; i < m ; i++){
              for(int j = 0 ; j < n; j++){
                  if(grid[i][j] == 2){
                      q.offer(new Pair(i, j, tm));
                  }
                  if(grid[i][j] == 1) freshCnt++;
              }
          }

          int[] dRow = {-1, 0 , 1 , 0};
          int[] dCol = { 0, 1, 0, -1};
          int count = 0;
          while( !q.isEmpty()){
              Pair curr = q.poll();
              int r = curr.row;
              int c = curr.col;
              tm = curr.tm;

              for(int i = 0; i< 4; i++){
                  int cr = r + dRow[i];
                  int cc = c + dCol[i];

                  if(cr >= 0 && cr < m && cc >= 0 && cc < n && grid[cr][cc] == 1){
                      q.offer(new Pair(cr, cc, tm+1));
                      grid[cr][cc] = 2;
                      count++;
                  }
              }
          }

          if(count != freshCnt) return -1 ;
          return tm;

      }
}
```
