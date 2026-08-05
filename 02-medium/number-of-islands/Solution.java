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
