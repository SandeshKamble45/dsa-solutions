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
