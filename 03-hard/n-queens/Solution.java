class Solution {
    public void nQueens(int col,char[][] bd, int n , List<List<String>> ans, int[] hmap, i
        if(col == n){
            ans.add(construct(bd, n));
            return;
        }
        for(int row = 0; row< n; row++){
            if(hmap[row] != 1 && ddmap[row+col] != 1 && udmap[row - col +( n-1)] != 1 ){
                 hmap[row] = 1;
                 ddmap[row+col] = 1;
                 udmap[row - col +( n-1)] = 1;
                 bd[row][col] = 'Q';
                 nQueens(col+1,bd, n, ans,hmap, ddmap, udmap);
                 hmap[row] = 0;
                 ddmap[row+col] = 0;
                 udmap[row - col + (n-1)] = 0;
                 bd[row][col] = '.';
            }
        }
    }

      public List<String> construct(char[][] bd,int n){
          List<String> temp = new ArrayList<>();
          for(int i = 0; i< n; i++){
              temp.add(new String(bd[i]));
          }
          return temp;
      }

      public List<List<String>> solveNQueens(int n) {
          List<List<String>> ans = new ArrayList<>();
          char[][] bd = new char[n][n];
          int[] hmap = new int[n];
          int[] ddmap = new int[2 * n -1];
          int[] udmap = new int[2 * n -1];
          for(char[] row : bd){
              Arrays.fill(row, '.');
          }
          nQueens(0,bd, n, ans , hmap, ddmap, udmap);
          return ans;
      }
}
