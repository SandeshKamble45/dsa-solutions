# Copy List with Random Pointer

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Linked List, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/copy-list-with-random-pointer)

## Problem

Deep-copy a linked list where each node has both a `next` pointer and an arbitrary `random` pointer.

## Approach

Simplest: one pass building a HashMap from original node to its clone, then a second pass wiring up `next` and `random` on the clones using that map. (An O(1)-space variant interleaves clone nodes directly into the original list.)

## Gotchas / Edge Cases

- `random` can point to null, to itself, or to any node — including ones not yet cloned when you first encounter them, which is exactly why the map (or interleaving) approach is needed.

## Complexity

- **Time:** O(n)
- **Space:** O(n) with hashmap / O(1) extra with interleaving trick

## Solution

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

      public Node(int val) {
          this.val = val;
          this.next = null;
          this.random = null;
      }
}
*/

class Solution {
    public void appendCopyNodeInBetween(Node head){
        Node temp = head;
        while(temp != null){
        Node copyNode = new Node(temp.val);
        copyNode.next = temp.next;
        temp.next = copyNode;
        temp = temp.next.next;
        }
    }

      public void assignRandomToCopyNode(Node head){
          Node temp = head;
          while( temp != null){
              if(temp.random != null){
              temp.next.random = temp.random.next;
              }else{
                  temp.next.random = null;
              }
              temp= temp.next.next;
          }
      }

      public Node deepCopyList (Node head){
          Node dummyNode = new Node(-1);
          Node res = dummyNode;
          Node temp = head;
          while(temp != null){
              res.next = temp.next;
              temp.next = temp.next.next;
              temp = temp.next;
              res = res.next;
          }
          return dummyNode.next;
      }
      public Node copyRandomList(Node head) {
        appendCopyNodeInBetween(head);
        assignRandomToCopyNode(head);
        return deepCopyList(head);
      }

}
```
