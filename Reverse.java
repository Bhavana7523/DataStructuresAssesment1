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
     public boolean checkfork(ListNode head,int k){
        int c=0;
        while(head!=null&&c<=k){
            c++;
            head=head.next;
        }
        if(c>=k)return true;
        return false;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int c=0;
           ListNode prev=null;
           ListNode curr=head;
           ListNode temp=null;
           if(!checkfork(head,k))return head;
           while(curr!=null&&c<k){
               temp=curr.next;
               curr.next=prev;
               prev=curr;
               curr=temp;
               c++;
           }
           if(temp!=null)head.next=reverseKGroup(temp,k);
       return prev;
    }
}
    
