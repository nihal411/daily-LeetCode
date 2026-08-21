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
    public ListNode mergeNodes(ListNode head) {
        if(head==null) return null;
        ListNode l = new ListNode(909090);
        ListNode n = l;
        ListNode p = head.next;
        int sum=0;
        while(p!=null){
            if(p.val==0){
                l.next=new ListNode(sum);
                l=l.next;
                sum=0;
            }else{
                sum+=p.val;
            }
            p=p.next;
        }
        return n.next;

    }
}