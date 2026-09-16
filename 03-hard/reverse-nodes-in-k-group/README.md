# Reverse Nodes in k-Group

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Linked List &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/reverse-nodes-in-k-group)

## Problem

Reverse the nodes of a linked list, k nodes at a time; if fewer than k nodes remain at the end, leave them as-is.

## Approach

Find the kth node ahead of the current position (if it doesn't exist, stop — fewer than k remain). Reverse that sublist of k nodes, then reconnect the previous group's tail to the new head, and continue with the next group.

## Gotchas / Edge Cases

- Checking whether a full group of k nodes exists *before* reversing is essential — reversing a partial group and then discovering it should've been left alone is a common bug source.

## Complexity

- **Time:** O(n)
- **Space:** O(1) iterative / O(n/k) if implemented recursively

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

      public ListNode findKthNode(ListNode temp, int k){
          int count = 1;
          while(temp != null){
              if(count == k){
                  return temp;
              }
              temp = temp.next;
              count++;
          }
          return null;
      }

      public ListNode reverse(ListNode head){
          ListNode prev = null;
          ListNode temp = head;
          while( temp != null){
              ListNode next = temp.next;
              temp.next = prev;
              prev = temp;
              temp = next;
          }
          return prev;

      }

      public ListNode reverseKGroup(ListNode head, int k) {

          ListNode temp = head;
          ListNode prevNode = null;
          while( temp != null ){
              ListNode kthNode = findKthNode(temp, k);
              if(kthNode == null){
                    prevNode.next = temp;
                  while(temp != null){
                    temp = temp.next;
                  }
              }else{
                  ListNode nextNode = kthNode.next;
              kthNode.next = null;

              ListNode newHead = reverse(temp);
              if(prevNode == null){
                  head = newHead;
              }else{
                  prevNode.next = newHead;
              }
              prevNode = temp;
              temp = nextNode;
              }

          }








          return head;

      }
}
```
