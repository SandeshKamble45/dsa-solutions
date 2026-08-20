# Task Scheduler

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Greedy, Heap / Math &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/task-scheduler)

## Problem

Given tasks and a cooldown `n` between identical tasks, find the minimum total time (including idle slots) to finish all tasks.

## Approach

Count each task's frequency. The answer is governed by the most frequent task: `max((maxFreq - 1) * (n + 1) + numberOfTasksWithMaxFreq, totalTasks)`.

## Gotchas / Edge Cases

- Must take the max with `totalTasks` — when there are many distinct tasks, idle slots may not even be needed.

## Complexity

- **Time:** O(n) counting + O(26 log 26) for the small alphabet
- **Space:** O(1) (26 task types)

## Solution

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int len = tasks.length;

          for(char ch : tasks){
              map.put(ch, map.getOrDefault(ch, 0) + 1);
          }
          int maxFreq = Integer.MIN_VALUE;
          int maxCount = 0;

          for(Map.Entry<Character, Integer> entry : map.entrySet() ){
              maxFreq = Math.max(maxFreq, entry.getValue());
          }

          for(Map.Entry<Character, Integer> entry : map.entrySet() ){
              if(entry.getValue() == maxFreq){
                  maxCount++;
              }
          }

          int t = (maxFreq - 1) * (n + 1) + maxCount ;
          return Math.max(len, t);

      }
}
```
