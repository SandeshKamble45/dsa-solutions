# Serialize and Deserialize Binary Tree

**Difficulty:** Hard &nbsp;|&nbsp; **Topic:** Tree, DFS, Design &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/serialize-and-deserialize-binary-tree)

## Problem

Design an algorithm to serialize a binary tree to a string, and deserialize that string back into the original tree structure.

## Approach

Preorder DFS serialization, explicitly writing a marker (e.g. "#") for null children so the structure is fully unambiguous. Deserialize by reading tokens in the same preorder sequence and recursively rebuilding.

## Gotchas / Edge Cases

- Without explicit null markers, preorder alone is ambiguous — you need them to know where each subtree ends.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
          if(root == null) return "";
          Queue<TreeNode> q = new LinkedList<>();
          StringBuilder sb = new StringBuilder();
          q.offer(root);
          while( !q.isEmpty()){
              TreeNode curr = q.poll();
              if(curr == null){
                  sb.append("n ");
                  continue;
              }
              sb.append(curr.val).append(" ");
              q.offer(curr.left);
              q.offer(curr.right);
          }

          return sb.toString();
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
          if(data.isEmpty()) return null;
          Queue<TreeNode> q = new ArrayDeque<>();
          String[] vals = data.split(" ");
          TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
          q.offer(root);
          int i = 1;
          while(!q.isEmpty() && i < vals.length ){
              TreeNode parent = q.poll();
              if(!vals[i].equals("n") ){
                   TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                   parent.left = left;
                   q.offer(left);
              }
              if(!vals[++i].equals("n") ){
                   TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                   parent.right = right;
                   q.offer(right);
              }
              i++;
          }

          return root;

      }
}
```
