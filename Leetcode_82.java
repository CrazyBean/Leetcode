/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //method 1, straight forward
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode slow = dummy, fast  = dummy.next, prev = null;
        boolean flag = false;
        while(fast != null){
            if(slow.val != fast.val){
                if(flag){
                    prev.next = fast;
                    slow.next = null;
                    slow = prev;
                    flag = false;
                }else{
                    prev = slow;
                    slow = fast;
                    fast = fast.next;
                }
            }else{
                slow.next = fast.next;
                fast = slow.next;
                flag = true;
                
            }
        }
        
        if(flag){
         prev.next = fast;
         slow.next = null;
         slow = prev;
         flag = false;
     }
     return dummy.next;
    }

    //method 2, follow up for method 1
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val)
                curr=curr.next;
            if(prev.next == curr){
                prev = curr;
            }else{
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }

    //method 3, recursive version, easy understand
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        if(head.next != null && head.val == head.next.val){
            while(head.next != null && head.val == head.next.val)
                head = head.next;
            return deleteDuplicates(head.next);
        }else{
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
    
    

}