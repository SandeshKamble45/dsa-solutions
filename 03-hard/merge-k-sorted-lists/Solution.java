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

      public ListNode merge(ListNode l1, ListNode l2){
          ListNode dummy = new ListNode(-1);
          ListNode temp = dummy;
          while(l1 != null && l2 != null){
              if(l1.val < l2.val ){
                  temp.next = l1;
                  l1 = l1.next;
              }else{
                  temp.next = l2;
                  l2 = l2.next;
              }
              temp = temp.next;
          }

          temp.next = (l1 != null)? l1 : l2;

          return dummy.next;
      }

      public ListNode mergeKLists(ListNode[] lists) {
          if(lists.length == 0) return null;
          int n = lists.length;
          int interval = 1;
          while( interval < n){
              for(int i = 0; i + interval < n; i += interval * 2){
                  lists[i] = merge(lists[i] , lists[interval + i]);
              }
              interval *= 2;
          }
          return lists[0];
      }
}
