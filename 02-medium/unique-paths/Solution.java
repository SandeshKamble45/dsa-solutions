class Solution {

      public int path(int m , int n, int[][] dp){
          if(m < 0 || n < 0) return 0;
          if(m == 0 && n == 0) return 1;
          if(dp[m][n] != -1) return dp[m][n];
          dp[m][n] = path(m - 1, n, dp) + path(m, n-1, dp);
          return dp[m][n];
      }

      public int uniquePaths(int m, int n) {
          int[][] dp = new int[m][n];
          for(int i = 0; i< m; i++) Arrays.fill(dp[i] , -1);
          int M = m -1 ; int N = n-1;
          return path(M ,N , dp);

      }
}
