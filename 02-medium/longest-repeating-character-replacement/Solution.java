class Solution {

      public int findMax(int[] arr){
          int max = 0;

          for(int num : arr){
            max = Math.max(max, num);
          }
          return max;
      }

      public int characterReplacement(String s, int k) {
          int maxLen = Integer.MIN_VALUE;
          int[] map = new int[26];
          int l = 0; int r = 0;
          int n = s.length();
          while(r < n ){
              int cr = s.charAt(r);
              map[cr - 'A']++;
              int len = r - l + 1;
              int maxFreq = findMax(map);
              int extras = len - maxFreq;
              if(extras <= k){
                   maxLen = Math.max(maxLen, len);
              }else{
                   map[s.charAt(l) - 'A']--;
                   l++;
              }
              r++;
          }
          return maxLen;
      }
}
