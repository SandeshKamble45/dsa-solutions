# Lowest Common Ancestor of a Binary Tree

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Tree, DFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree)

## Problem

Find the lowest common ancestor of two given nodes in a general (not necessarily BST) binary tree.

## Approach

Recursive DFS: if the current node is `p` or `q`, return it. Otherwise recurse into both children; if both sides return non-null, the current node is the LCA — otherwise propagate up whichever side found something.

## Gotchas / Edge Cases

- Assumes both `p` and `q` exist in the tree.
- The elegance here is that a non-null return from *both* children is exactly the LCA condition.

## Complexity

- **Time:** O(n)
- **Space:** O(h) recursion stack

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null || root == p || root == q){
             return root;
         }
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

          if(left == null){
              return right;
          }
          else if(right == null ){
              return left;
          }
          else{
              return root;
          }
      }
}
```
