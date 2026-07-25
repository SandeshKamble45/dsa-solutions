class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); int preSum = 0;
        for(int i = 0 ; i < n; i++){
            preSum += nums[i];
            int x = preSum - k;
            if(map.containsKey(x)){
                 count += map.get(x);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1 );
        }
        return count;
    }
}
