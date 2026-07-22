# Top K Frequent Elements

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Heap, Bucket Sort &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/top-k-frequent-elements)

## Problem

Return the k most frequent elements in an array.

## Approach

Count frequencies with a HashMap, then either maintain a min-heap of size k (popping the smallest whenever it exceeds k) or bucket-sort values by frequency for a linear-time solution.

## Gotchas / Edge Cases

- Bucket sort by frequency achieves true O(n) since frequency is bounded by array length — beats the O(n log k) heap approach asymptotically.

## Complexity

- **Time:** O(n log k) heap / O(n) bucket sort
- **Space:** O(n)

## Solution

```java
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
```
