class Solution {
    public void dfs(int i, int[] nums, List<Integer> temp,      List<List<Integer>> ans){
        int n = nums.length;
        if(i == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(i+1, nums, temp, ans);
        temp.remove(temp.size() -1);
        dfs(i+1, nums, temp, ans);
    }

      public List<List<Integer>> subsets(int[] nums) {
          List<Integer> temp = new ArrayList<>();
          List<List<Integer>> ans = new ArrayList<>();
          dfs(0, nums, temp, ans);
          return ans;
      }
}
