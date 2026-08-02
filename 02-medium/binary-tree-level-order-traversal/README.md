# Binary Tree Level Order Traversal

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Tree, BFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal)

## Problem

Return the level-order (breadth-first) traversal of a binary tree's node values, grouped by level.

## Approach

Standard BFS with a queue. Before processing each level, capture the current queue size — that many dequeues make up exactly one level.

## Gotchas / Edge Cases

- Snapshot the queue size *before* the inner loop begins; recomputing it mid-loop (after enqueuing children) breaks the level grouping.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
/**
  * Definition for a binary tree node.
  * public class TreeNode {
  *      int val;
  *      TreeNode left;
  *      TreeNode right;
  *      TreeNode() {}
  *      TreeNode(int val) { this.val = val; }
  *      TreeNode(int val, TreeNode left, TreeNode right) {
  *          this.val = val;
  *          this.left = left;
  *          this.right = right;
  *      }
  * }
  */
class Solution {
      public List<List<Integer>> levelOrder(TreeNode root) {
          Queue<TreeNode> q = new ArrayDeque<>();
          List<List<Integer>> ans = new ArrayList<>();
          if(root == null) return ans;
          q.offer(root);
          while(!q.isEmpty()){
              int size = q.size();
              List<Integer> temp = new ArrayList<>();
              for(int i = 0 ; i< size; i++){
                  TreeNode curr = q.poll();
                  if(curr.left != null) q.offer(curr.left);
                  if(curr.right != null) q.offer(curr.right);
                  temp.add(curr.val);
              }
              ans.add(temp);
          }
          return ans;
      }
}
```
