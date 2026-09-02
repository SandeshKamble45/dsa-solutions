class Solution {
      public int largestRectangleArea(int[] arr) {
         int n = arr.length;
         Stack<Integer> st = new Stack<>();
         int maxArea = 0;
         for (int i = 0; i < n; i++) {
             while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                 int element = st.pop();
                 int pse = st.isEmpty() ? -1 : st.peek();
                 int area = arr[element] * (i - pse - 1 );
                 maxArea = Math.max(maxArea, area);
             }
             st.push(i);
         }
         while(!st.isEmpty()){
             int element = st.peek(); st.pop();
             int pse = st.isEmpty() ? -1 : st.peek();
             int area = arr[element] * (n - pse - 1 );
             maxArea = Math.max(maxArea, area);
         }
         return maxArea;
    }

      public int maximalRectangle(char[][] mat) {
          int n = mat.length;
          int m = mat[0].length;
          int[] ht = new int[m];
          int max = 0;
          for(int i = 0; i < n; i++){
              for(int j = 0; j< m; j++){
                  if(mat[i][j] == '1'){
                     ht[j] += 1 ;
                  }else{
                     ht[j] = 0 ;
                  }
              }
                  int area = largestRectangleArea(ht);
                  max = Math.max(area, max);
          }

          return max;
      }
}
