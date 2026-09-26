# Split Array Largest Sum

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Binary Search on Answer &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/split-array-largest-sum)

## Problem

Split an array into m contiguous non-empty subarrays to minimize the largest sum among them.

## Approach

Binary search on the answer itself — the possible range is `[max(nums), sum(nums)]`. For each candidate max-sum, greedily simulate partitioning the array (starting a new subarray whenever adding the next element would exceed the candidate) and count how many subarrays that requires.

## Gotchas / Edge Cases

- The greedy partition-count function is the crux — get it right and the binary search around it is straightforward boilerplate.

## Complexity

- **Time:** O(n log(sum(nums)))
- **Space:** O(1)

## Solution

```java
class Solution {
    public int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i< arr.length ;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

      public int findSum(int[] arr){
          int sum = 0;
          for(int i = 0; i< arr.length ;i++){
              sum += arr[i];
          }
          return sum;
      }

      public int allocateSums(int[] arr, int max){
          int currSum = 0; int group = 1;
          for(int i = 0; i < arr.length; i++){
              if(currSum + arr[i] <= max){
                  currSum += arr[i];
              }else{
                  group++;
                  currSum = arr[i];
              }
          }
          return group;
      }

      public int splitArray(int[] nums, int k) {
          int n = nums.length;
          if(k > n) return -1;
          int low = findMax(nums); int high = findSum(nums);
          while(low <= high){
              int mid = low + (high - low)/2;
              int split = allocateSums(nums, mid);
              if(split <= k){
                  high = mid - 1;
              }else{
                  low = mid + 1;
              }
          }
          return low;
      }
}
```
