# Linked List Cycle II

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Linked List, Floyd's Cycle Detection &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/linked-list-cycle-ii)

## Problem

Detect whether a linked list has a cycle, and if so, return the node where the cycle begins.

## Approach

Floyd's tortoise-and-hare to detect a cycle first. Once slow and fast pointers meet, reset one pointer to the head and advance both one step at a time — they meet exactly at the cycle's start.

## Gotchas / Edge Cases

- The second phase relies on a specific distance proof (distance from head to cycle start equals distance from meeting point to cycle start, walking forward) — it's a memorизable pattern, not something to re-derive from scratch each time.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) {
 *          val = x;
 *          next = null;
 *      }
 * }
 */
public class Solution {
     public ListNode detectCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                 slow = head;
                 while(slow != fast){
                     slow = slow.next;
                     fast = fast.next;
                 }
                 return slow;
             }
         }

          return null;
      }
}
```
