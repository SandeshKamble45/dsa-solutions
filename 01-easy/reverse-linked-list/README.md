# Reverse Linked List

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Linked List &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/reverse-linked-list)

## Problem

Reverse a singly linked list and return the new head.

## Approach

Iterate with three pointers: `prev`, `curr`, and `next`. At each node, save `curr.next`, point `curr.next` to `prev`, then shift `prev` and `curr` forward.

## Gotchas / Edge Cases

- Save `next` before rewiring `curr.next`, or you lose the rest of the list.
- Return `prev` at the end, not `curr` (which will be null).

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Solution

```java
/**
  * Definition for singly-linked list.
  * public class ListNode {
  *      int val;
  *      ListNode next;
  *      ListNode() {}
  *      ListNode(int val) { this.val = val; }
  *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  * }
  */
class Solution {
      public ListNode reverseList(ListNode head) {
          ListNode prev = null;
          ListNode curr = head;
          while( curr != null){
              ListNode next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
          }
          return prev;
      }
}
```
