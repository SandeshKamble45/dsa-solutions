class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int min = nums[0];
        int maxProfit = 0;
        for(int i = 1; i< n; i++){
            if(nums[i] < min){
                 min = nums[i];
            }
            maxProfit = Math.max(maxProfit, nums[i] - min);
        }

          return maxProfit;
      }
}
