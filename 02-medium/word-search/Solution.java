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
