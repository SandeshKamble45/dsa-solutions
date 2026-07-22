class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i< nums.length; i++){
            freqMap.put(nums[i] , freqMap.getOrDefault(nums[i], 0) + 1);
        }

          List<List<Integer>> buckets = new ArrayList<>();

          for (int i = 0; i <= n; i++) {
      buckets.add(new ArrayList<>());
}
          for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
               int freq = entry.getValue();
               int num = entry.getKey();
               buckets.get(freq).add(num);
          }

          int[] ans = new int[k];
          int ind = 0;
          for(int freq = n; freq >= 1; freq--){

              for(int num : buckets.get(freq)){
                  ans[ind++] = num;
                  if(ind == k){
                      return ans;
                  }
              }
          }
          return ans;
      }
}
