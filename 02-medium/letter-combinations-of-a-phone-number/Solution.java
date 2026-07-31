class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

      public List<String> letterCombinations(String digits) {
          if (!digits.isEmpty()) dfs(0, digits, "");
          return res;
      }

      private void dfs(int i, String digits, String s) {
          if (i == digits.length()) {
              res.add(s);
              return;
          }
          for (char c : map[digits.charAt(i) - '0'].toCharArray())
              dfs(i + 1, digits, s + c);
      }
}
