# Clone Graph

**Difficulty:** Medium &nbsp;|&nbsp; **Topic:** Graph, DFS/BFS, Hashing &nbsp;|&nbsp; [Problem on LeetCode](https://leetcode.com/problems/clone-graph)

## Problem

Deep-clone a connected undirected graph given a reference to one of its nodes.

## Approach

DFS (or BFS) from the given node, using a HashMap from original node to its clone. Before recursing into a neighbor, check the map — if the clone already exists, reuse it instead of recursing again.

## Gotchas / Edge Cases

- The graph can contain cycles — without the map for memoization you'll recurse forever.

## Complexity

- **Time:** O(V + E)
- **Space:** O(V)

## Solution

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

          Map<Node, Node> map = new HashMap<>();
          Queue<Node> q = new ArrayDeque<>();

          map.put(node, new Node(node.val));
          q.offer(node);

          while( !q.isEmpty() ){
              Node curr = q.poll();

              for(Node neib : curr.neighbors){

                  if( !map.containsKey(neib)){
                      map.put(neib, new Node(neib.val));
                      q.offer(neib);
                  }

                  map.get(curr).neighbors.add(map.get(neib));
              }

          }

          return map.get(node);
      }
}
```
