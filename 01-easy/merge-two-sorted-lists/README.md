# Merge Two Sorted Lists

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Linked List &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/merge-two-sorted-lists)

## Problem

Merge two sorted linked lists into a single sorted list.

## Approach

Use a dummy head node and a tail pointer. Repeatedly compare the heads of both lists, attach the smaller one to the tail, and advance that list's pointer.

## Gotchas / Edge Cases

- When one list runs out, attach the entirety of the remaining list — don't forget this tail step.

## Complexity

- **Time:** O(m + n)
- **Space:** O(1) extra (excluding output list)

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
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode t1 = list1;
         ListNode t2 = list2;
         ListNode dummy = new ListNode(-1);
         ListNode curr = dummy;
         while (t1 != null && t2 != null) {
             if (t1.val <= t2.val) {
                 curr.next = t1;
                 curr = curr.next;
                 t1 = t1.next;
             } else {
                 curr.next = t2;
                 curr = curr.next;
                 t2 = t2.next;
             }
         }
         curr.next = t1 != null ? t1 : t2;

          return dummy.next;
      }
}
```
