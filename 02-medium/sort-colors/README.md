# Sort Colors

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array, Two Pointers (Dutch National Flag) &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/sort-colors)

## Problem

Sort an array containing only 0s, 1s, and 2s in place, in one pass, without a full sort.

## Approach

Dutch National Flag partitioning with three pointers: `low`, `mid`, `high`. Swap 0s to the front, leave 1s in place, and swap 2s to the back, advancing pointers according to the value found.

## Gotchas / Edge Cases

- After swapping with `high`, don't advance `mid` — the swapped-in value still needs to be examined.
- After swapping with `low`, it's safe to advance both `low` and `mid`.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {

      public void swap(int[] nums , int i , int j){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
      }

      public void sortColors(int[] nums) {
          int n = nums.length;
          int low = 0; int mid = 0; int high = n - 1;
          while(mid <= high){
              if(nums[mid] == 0){
                  swap(nums, low, mid);
                  low++;
                  mid++;
              }else if(nums[mid] == 1){
                  mid++;
              }else{
                  swap(nums, mid, high);
                  high--;
              }
          }
      }
}
```
