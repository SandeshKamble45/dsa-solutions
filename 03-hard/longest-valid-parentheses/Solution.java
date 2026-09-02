class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        java.util.Stack<Integer> st = new java.util.Stack<>();
        st.push(-1); // base

          for (int i = 0; i < s.length(); i++) {
              if (s.charAt(i) == '(') {
                  st.push(i);
              } else {
                  st.pop();
                  if (st.isEmpty()) st.push(i);
                  else max = Math.max(max, i - st.peek());
              }
          }
          return max;
      }
}
