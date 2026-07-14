class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;
        //transporse
        for(int i = 0; i< n ; i++){
            for(int j = 0 ; j < i; j++){
                 int temp = arr[i][j];
                 arr[i][j] = arr[j][i];
                 arr[j][i] = temp;
            }
        }

          // reverse
          for(int i = 0; i< n ; i++){
              int j = 0 ; int k = n-1;
              while( j < k){
                  int temp = arr[i][j];
                  arr[i][j] = arr[i][k];
                  arr[i][k] = temp;
                  j++; k--;
              }
          }
      }
}
