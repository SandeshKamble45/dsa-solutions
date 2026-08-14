class Solution {

      public boolean findWord(int i, String s, List<String> dict, Boolean[] memo){
          if(i == s.length()){
              return true;
          }
          if(memo[i] != null) return memo[i];
          for( String w : dict){
              int len = i + w.length();
              if( len <= s.length()){
                  if(s.substring(i, len).equals(w)){
                      if(findWord(len,s, dict, memo)){
                           memo[i] = true;
                           return true;
                      }
                  }
              }
          }
          memo[i] = false;
          return false;
      }

      public boolean wordBreak(String s, List<String> wordDict) {
          Boolean[] memo = new Boolean[s.length() + 1];
         return findWord(0, s, wordDict, memo);
      }
}
