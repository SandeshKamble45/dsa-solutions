# Validate Binary Search Tree

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Tree, DFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/validate-binary-search-tree)

## Problem

Determine whether a binary tree satisfies the BST property.

## Approach

Recursive DFS carrying a valid `(low, high)` range for each node; a node must lie strictly within that range, and its children get narrowed ranges accordingly.

## Gotchas / Edge Cases

- Use a wide type (long, or sentinel values) for the bounds — testing against `Integer.MIN_VALUE`/`MAX_VALUE` node values can otherwise overflow.
- An inorder-traversal-must-be-strictly-increasing check is an equally valid alternative approach.

## Complexity

- **Time:** O(n)
- **Space:** O(h)

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

      public boolean isValid(TreeNode root, long min, long max){
          if(root == null) return true;
          if(root.val <= min || root.val >= max){
              return false;
          }
          return isValid(root.left,min, root.val) && isValid(root.right, root.val, max);
      }

      public boolean isValidBST(TreeNode root) {
          return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
      }
}
```
