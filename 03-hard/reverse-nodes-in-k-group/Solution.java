/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

      public ListNode findKthNode(ListNode temp, int k){
          int count = 1;
          while(temp != null){
              if(count == k){
                  return temp;
              }
              temp = temp.next;
              count++;
          }
          return null;
      }

      public ListNode reverse(ListNode head){
          ListNode prev = null;
          ListNode temp = head;
          while( temp != null){
              ListNode next = temp.next;
              temp.next = prev;
              prev = temp;
              temp = next;
          }
          return prev;

      }

      public ListNode reverseKGroup(ListNode head, int k) {

          ListNode temp = head;
          ListNode prevNode = null;
          while( temp != null ){
              ListNode kthNode = findKthNode(temp, k);
              if(kthNode == null){
                    prevNode.next = temp;
                  while(temp != null){
                    temp = temp.next;
                  }
              }else{
                  ListNode nextNode = kthNode.next;
              kthNode.next = null;

              ListNode newHead = reverse(temp);
              if(prevNode == null){
                  head = newHead;
              }else{
                  prevNode.next = newHead;
              }
              prevNode = temp;
              temp = nextNode;
              }

          }








          return head;

      }
}
