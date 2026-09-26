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
