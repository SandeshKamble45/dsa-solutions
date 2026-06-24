# Maximum Depth of Binary Tree

**Difficulty:** Easy &nbsp;|&nbsp; **Topic:** Tree, DFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/maximum-depth-of-binary-tree)

## Problem

Find the maximum depth (number of nodes on the longest root-to-leaf path) of a binary tree.

## Approach

Simple recursive DFS: depth of a node is `1 + max(depth(left), depth(right))`, with a null node returning depth 0.

## Gotchas / Edge Cases

- Don't forget the base case — an empty tree has depth 0, not 1.

## Complexity

- **Time:** O(n)
- **Space:** O(h) recursion stack, h = tree height

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
     public int maxDepth(TreeNode root) {
         if(root == null) return 0;

          int lh = maxDepth(root.left);
          int rh = maxDepth(root.right);

          return 1 + Math.max(lh, rh);
      }
}
```
