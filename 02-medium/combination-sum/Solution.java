class Solution {

      public void findSum(int ind, int[] arr, int target, List<Integer> temp,
                          List<List<Integer>> ans)

      {
          int n = arr.length;

             if( target == 0){
                 ans.add(new ArrayList<>(temp));
                 return;
             }
             if(ind == n){
             return;
             }

          if(arr[ind] <= target){
              temp.add(arr[ind]);
              findSum(ind, arr, target - arr[ind], temp, ans);
              temp.remove(temp.size() - 1);
          }
          findSum(ind + 1, arr, target, temp, ans);

      }

      public List<List<Integer>> combinationSum(int[] candidates, int target) {
          List<List<Integer>> ans = new ArrayList<>();
          List<Integer> temp = new ArrayList<>();
          findSum(0, candidates, target, temp, ans);
          return ans;
      }
}
