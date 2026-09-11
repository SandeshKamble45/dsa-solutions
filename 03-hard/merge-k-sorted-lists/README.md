# Merge k Sorted Lists

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Heap, Divide and Conquer, Linked List &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/merge-k-sorted-lists)

## Problem

Merge k sorted linked lists into one sorted list.

## Approach

Use a min-heap holding the current head of each of the k lists. Repeatedly pop the smallest node, append it to the result, and push that node's `.next` back into the heap if it exists. (Pairwise divide-and-conquer merging is an equally valid alternative.)

## Gotchas / Edge Cases

- The heap needs a custom comparator on node value, since Java's PriorityQueue doesn't know how to compare ListNode objects by default.
- Handle empty lists in the input array — don't push a null head into the heap.

## Complexity

- **Time:** O(N log k), N = total nodes across all lists
- **Space:** O(k)

## Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

      public ListNode merge(ListNode l1, ListNode l2){
          ListNode dummy = new ListNode(-1);
          ListNode temp = dummy;
          while(l1 != null && l2 != null){
              if(l1.val < l2.val ){
                  temp.next = l1;
                  l1 = l1.next;
              }else{
                  temp.next = l2;
                  l2 = l2.next;
              }
              temp = temp.next;
          }

          temp.next = (l1 != null)? l1 : l2;

          return dummy.next;
      }

      public ListNode mergeKLists(ListNode[] lists) {
          if(lists.length == 0) return null;
          int n = lists.length;
          int interval = 1;
          while( interval < n){
              for(int i = 0; i + interval < n; i += interval * 2){
                  lists[i] = merge(lists[i] , lists[interval + i]);
              }
              interval *= 2;
          }
          return lists[0];
      }
}
```
