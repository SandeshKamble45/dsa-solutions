class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int n = s.length();
        int l = 0; int r = 0;
        int maxC = 0;
        while(r < n){
           char ch = s.charAt(r);
           while(map[ch] == 1){
             map[s.charAt(l)] = 0;
             l++;
           }
             map[ch] = 1;
             maxC = Math.max(maxC, r - l + 1);
             r++;
        }
        return maxC;
    }
}
