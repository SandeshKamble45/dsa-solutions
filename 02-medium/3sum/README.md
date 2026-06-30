# 3Sum

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Two Pointers, Sorting &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/3sum)

## Problem

Find all unique triplets in the array that sum to zero.

## Approach

Sort the array. Fix one element `i`, then use two pointers (`left`, `right`) scanning inward across the remainder of the array looking for a pair that sums to `-nums[i]`.

## Gotchas / Edge Cases

- Skip duplicate values for `i`, `left`, and `right` to avoid duplicate triplets in the output.
- After a match, move both pointers inward and continue skipping duplicates.

## Complexity

- **Time:** O(n^2)
- **Space:** O(1) extra (excluding sort / output)

## Solution

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       int n = nums.length;
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);
        for(int i = 0; i< n - 2; i++){
            if( i > 0 && nums[i - 1] == nums[i]){
                 continue;
            }
            int j = i+1; int k = n-1;
            while( j < k){
                 if(nums[i] + nums[j] + nums[k] < 0){
                     j++;
                     while( j < k && nums[j] == nums[j - 1] ) j++;
                 }else if(nums[i] + nums[j] + nums[k] > 0 ){
                     k--;
                      while( j < k && nums[k] == nums[k + 1] ) k--;
                 }else{
                     ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                     j++;
                     k--;
                     while( j < k && nums[j] == nums[j - 1] ) j++;
                     while(j < k && nums[k] == nums[k + 1] ) k--;
                 }
            }
        }
        return ans;
    }
}
```
