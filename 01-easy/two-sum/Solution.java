class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[2];
        for(int i = 0; i< n; i++ ){
            int preValue = target - nums[i];
            if(map.containsKey(preValue)){
                 ans[0] = map.get(preValue);
                 ans[1] = i;
                 break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
