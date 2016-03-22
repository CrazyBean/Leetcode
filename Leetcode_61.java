/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        int len;
        for(len = 0; fast.next != null; len++)//get the total length
            fast = fast.next;
            
        for(int i = len - k % len; i > 0; i--)//find the pivot point
            slow = slow.next;
          
        //finish the rotate  
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
        
        
        
        
    }
}