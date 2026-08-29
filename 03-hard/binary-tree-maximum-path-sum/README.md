# Binary Tree Maximum Path Sum

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Tree, DFS &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/binary-tree-maximum-path-sum)

## Problem

Find the maximum path sum in a binary tree, where the path can start and end at any nodes (not necessarily passing through the root).

## Approach

Recursive DFS computing the max "single-side" gain from each node (clamped to 0 to ignore unhelpful negative branches) for the parent to use. Separately, at each node, update a global maximum using *both* children's gains plus the node's own value — a path that forks at this node.

## Gotchas / Edge Cases

- The value *returned* to the parent can only include one side (a real path can't fork), but the value used for the global max update can legally use both sides.

## Complexity

- **Time:** O(n)
- **Space:** O(h) recursion stack

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

      public int findPathSum(TreeNode root, int[] max){
          if(root == null) return 0;

          int lh = Math.max(0, findPathSum(root.left, max) ) ;
          int rh = Math.max(0, findPathSum(root.right, max) ) ;

          max[0] = Math.max(max[0], root.val + lh + rh) ;

          return root.val + Math.max(lh, rh);

      }

      public int maxPathSum(TreeNode root) {
          int[] max = new int[1];
          max[0] = Integer.MIN_VALUE;
          findPathSum(root, max);
          return max[0];
      }
}
```
