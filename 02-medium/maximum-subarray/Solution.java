class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i< n; i++){
          currSum = Math.max(currSum + nums[i], nums[i]);
          max = Math.max(max, currSum);
        }
        return max;
    }
}
