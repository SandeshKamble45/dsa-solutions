class Solution {

      public void dfs(int[] nums, int ind, List<List<Integer>> ans) {
          int n = nums.length;
          if (ind == n) {
              List<Integer> temp = new ArrayList<>();
              for (int i = 0; i < n; i++) {
                  temp.add(nums[i]);
              }
              ans.add(new ArrayList<>(temp));
              return;
          }

          for (int i = ind; i < n; i++) {
              swap(i , ind, nums);
              dfs(nums, ind + 1, ans);
              swap(i , ind, nums);
          }
      }

      public void swap(int i, int j , int[] nums){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }

      public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> ans = new ArrayList<>();
          int n = nums.length;
          dfs(nums, 0, ans);
          return ans;
      }
}
