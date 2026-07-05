# Koko Eating Bananas

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Binary Search on Answer &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/koko-eating-bananas)

## Problem

Find the minimum integer eating speed so Koko can finish all banana piles within h hours.

## Approach

Binary search over possible speeds, from 1 to `max(piles)`. For each candidate speed, compute total hours needed (`ceil(pile/speed)` summed over all piles) and narrow the search based on whether that's within `h`.

## Gotchas / Edge Cases

- Hours per pile must be a ceiling division — `(pile + speed - 1) / speed`, not integer truncation.

## Complexity

- **Time:** O(n log(max(piles)))
- **Space:** O(1)

## Solution

```java
class Solution {
    public int findMax(int[] arr){
        int max = arr[0];
        for(int i = 0; i< arr.length ; i++){
            if(arr[i] > max){
                 max = arr[i];
            }
        }
        return max;
    }

      public long computeTotalHours(int[] arr , int mid){
          long totalHours = 0;
          for(int i = 0; i < arr.length; i++){
              totalHours += (arr[i] + mid - 1) / mid ;
          }
          return totalHours;
      }

      public int minEatingSpeed(int[] piles, int h) {
          int low = 1; int high = findMax(piles);
          while( low <= high ){
              int mid = low + (high - low)/2;
              long totalHours = computeTotalHours(piles, mid);
              if(totalHours <= h){
                  high = mid - 1;
              }else{
                  low = mid + 1;
              }
          }
          return low;
      }
}
```
