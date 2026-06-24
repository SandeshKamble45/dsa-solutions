# Add Two Numbers

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Linked List, Math &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/add-two-numbers)

## Problem

Two numbers are stored in reverse order as linked lists of single digits; add them and return the sum as a linked list.

## Approach

Simulate elementary school addition: walk both lists simultaneously, adding digits plus a running carry, and build the result list one node at a time.

## Gotchas / Edge Cases

- The two lists can have different lengths — treat a missing node as digit 0.
- Don't forget a final extra node if a carry remains after both lists are exhausted.

## Complexity

- **Time:** O(max(m, n))
- **Space:** O(max(m, n)) for the output list

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
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

          ListNode t1 = l1;
          ListNode t2 = l2;
          ListNode dummy = new ListNode(-1);
          ListNode curr = dummy;
          int carry = 0 ;

          while( t1 != null || t2 != null || carry != 0 ){
              int sum = carry;

              if(t1 != null){
                  sum += t1.val;
                  t1 = t1.next;
              }
              if(t2 != null){
                  sum += t2.val;
                  t2 = t2.next;
              }

              int digit = sum % 10;
               carry = sum / 10;

              ListNode newNode = new ListNode(digit);
              curr.next = newNode;
              curr = curr.next;
          }
          return dummy.next;
      }
}
```
