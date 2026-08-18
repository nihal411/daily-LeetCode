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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int a =0;
        int b=0,c=0;
        int s=0;
        ListNode t = new ListNode(-999999);
        ListNode tail = t;
        while(A!=null || B!=null || c!=0){
            a=(A!=null)? A.val:0;
            b=(B!=null)? B.val:0;
            s=a+b+c;
            c=s/10;
            tail.next=new ListNode(s%10);
            tail=tail.next;
            if(A!=null) A=A.next;
            if(B!=null) B=B.next;
        }
        return t.next;
    }
}