class Solution {

      public String minWindow(String s, String t) {

          int freq[] = new int[128];
          for(char ch : t.toCharArray()){
              freq[ch]++;
          }
          int m = s.length();
          int n = t.length();
          int l = 0 ; int r = 0; int count = 0;int minLen = Integer.MAX_VALUE;
          String ans = ""; int sInd = -1;
          while(r < m){
              if( freq[s.charAt(r)] > 0 ){
                  count++;
              }
              freq[s.charAt(r)]--;
              while(count == n){
                if( r - l + 1 < minLen ){
                  minLen = r - l + 1;
                  sInd = l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l++)] > 0){
                  count--;
                }
              }
              r = r + 1;
          }

          if(sInd == -1){
              return "";
          }else{
              return s.substring(sInd,sInd + minLen);
          }
      }
}
