# Next Permutation

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Array &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/next-permutation)

## Problem

Rearrange numbers into the lexicographically next greater permutation, in place; if none exists, produce the lowest (sorted ascending) order.

## Approach

Scan from the right to find the first index `i` where `nums[i] < nums[i+1]`. Then find the rightmost index `j > i` with `nums[j] > nums[i]`, swap them, and reverse the suffix after `i`.

## Gotchas / Edge Cases

- If no such `i` exists, the array is in fully descending order — the "next permutation" wraps around to the ascending order, i.e. just reverse the whole array.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
class Solution {
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       int index = -1;
       int breakpoint = 0;
       for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                 index = i;
                 break;
            }
        }

          if(index    == -1){
                     int l = 0; int r = n-1;
                        while(l < r){
                            int temp = nums[l];
                            nums[l] = nums[r];
                            nums[r] = temp;
                            l++; r--;
                        }
          }

          else{
              for(int i = n-1 ; i >= index; i--){
                  if(nums[i] > nums[index]){
                      int temp = nums[i];
                          nums[i]= nums[index];
                          nums[index] = temp;
                          break;
                  }
              }

              int l = index + 1; int r = n-1;
              while(l < r){
                  int temp = nums[l];
                  nums[l] = nums[r];
                  nums[r] = temp;
                  l++; r--;
              }
          }
      }
}
```
