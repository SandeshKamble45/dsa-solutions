class Solution {
    public int largestRectangleArea(int[] arr) {
        int max = 0;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< arr.length; i++){
           while(!st.isEmpty() && arr[st.peek()] >= arr[i] ){
             int top = st.pop();
             int pse = st.isEmpty() ? -1 : st.peek();
             max = Math.max(max, arr[top] * (i - pse - 1) );
           }
           st.push(i);
        }
        while( !st.isEmpty() ){
             int top = st.pop();
             int pse = st.isEmpty() ? -1 : st.peek();
             max = Math.max(max, arr[top] * (n - pse - 1)) ;
        }
        return max;
    }
}
