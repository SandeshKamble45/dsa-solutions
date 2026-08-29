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
