# Find Median from Data Stream

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Heap, Design &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/find-median-from-data-stream)

## Problem

Design a data structure that supports adding numbers one at a time and finding the median of all numbers added so far, efficiently.

## Approach

Maintain two heaps: a max-heap for the lower half of numbers and a min-heap for the upper half. After every insertion, rebalance so their sizes differ by at most one; the median is then derivable from the heap tops in O(1).

## Gotchas / Edge Cases

- Rebalance after *every* insertion, not periodically — otherwise the size-difference invariant breaks and the median becomes wrong.

## Complexity

- **Time:** O(log n) per add, O(1) to find median
- **Space:** O(n)

## Solution

```java
class MedianFinder {

      PriorityQueue<Integer> maxheap;
      PriorityQueue<Integer> minheap;

      public MedianFinder() {
         maxheap = new PriorityQueue<>(Collections.reverseOrder());
         minheap = new PriorityQueue<>();
      }

      public void addNum(int num) {

          maxheap.offer(num);
          minheap.offer(maxheap.poll());

          if(minheap.size() > maxheap.size()){
              maxheap.offer(minheap.poll());
          }
      }

      public double findMedian() {
        if(maxheap.size() > minheap.size()){
          return maxheap.peek();
        }
          return (maxheap.peek() + minheap.peek()) / 2.0;


      }
}
```
