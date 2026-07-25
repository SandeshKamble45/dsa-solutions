class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && temp[st.peek()] < temp[i]){
                 int prev = st.pop();
                 ans[prev] = i - prev;
            }

              st.push(i);
          }
          return ans;
      }
}
