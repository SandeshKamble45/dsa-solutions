class Solution {
    int start = 0, maxLen = 0;

      public String longestPalindrome(String s) {
          for (int i = 0; i < s.length(); i++) {
              expand(s, i, i);     // odd length
              expand(s, i, i + 1); // even length
          }
          return s.substring(start, start + maxLen);
      }

      private void expand(String s, int l, int r) {
          while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
              l--;
              r++;
          }

          int len = r - l - 1; // actual palindrome length

          if (len > maxLen) {
              maxLen = len;
              start = l + 1;
          }
      }
}
