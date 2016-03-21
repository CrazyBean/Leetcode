/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //iterative
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null && curr.next != null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;
            curr = curr.next;
            prev.next = next;
            prev = next.next;
        }
        return dummy.next;
    }
    
}


public class Solution {  
    //recursive
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode temp = swapPairs(head.next.next);
        ListNode next = head.next;
        head.next = temp;
        next.next = head;
        return next;
    }
}