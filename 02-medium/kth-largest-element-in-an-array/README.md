# Kth Largest Element in an Array

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Heap, Quickselect &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array)

## Problem

Find the kth largest element in an unsorted array.

## Approach

Maintain a min-heap of size k: push every element, and pop whenever the heap exceeds size k. What's left on top is the kth largest. (Quickselect partitioning gives average O(n) if you need better performance.)

## Gotchas / Edge Cases

- Randomize the pivot if implementing Quickselect — a naive pivot choice degrades to O(n^2) on adversarial input.

## Complexity

- **Time:** O(n log k) heap / O(n) average with Quickselect
- **Space:** O(k) heap / O(1) Quickselect

## Solution

```java
class Solution {
    Random rand = new Random();

      public int ans;
      public void swap(int[] nums, int i, int j){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }

      public int findPartition(int[] nums, int low, int high){
          int random = low + rand.nextInt(high - low + 1);
          swap(nums, random, low);
          int pivot = nums[low];
          int i = low; int j = high;
          while( i < j){
              while(nums[i] <= pivot && i < high) i++;
              while( nums[j] > pivot && j > low ) j--;
              if( i < j){
                  swap(nums, i, j);
              }
          }
          swap(nums, low, j);
          return j;
      }

      public int sort(int[] nums, int low, int high, int target){
          int pI = findPartition(nums, low, high);
          if(pI == target){
              return nums[pI];
          }else if(pI < target){
             return sort(nums, pI + 1, high, target);
          }else{
              return sort(nums, low, pI - 1, target);
          }
      }

      public int findKthLargest(int[] nums, int k) {
          int n = nums.length;
          int low = 0;
          int high = n - 1;
          int target = n - k;
          return sort(nums, low, high , target);
      }
}
```
