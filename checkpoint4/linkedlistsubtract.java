// https://www.interviewbit.com/problems/subtract/

/*Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        
        int length = 0;
        
        ListNode B = A;
        while (B != null) {
            length += 1;
            B = B.next;
        }
        
        int half = (length % 2 == 0) ? length/2 : length/2 + 1;
        
        int counter = 0;
        ListNode first = A;
        ListNode previous = first;
        while(counter < half) {
            previous = first;
            first = first.next;
            counter ++;
        }
        
        
        ListNode second = first;
        previous.next = null;
        
        first = A;
        
        second = reverse(second);
        ListNode temp = second;
        
        while(temp != null) {
            previous = first;
            first.val = temp.val - first.val;
            first = first.next;
            temp = temp.next;
        }
        
        while(previous != null && previous.next != null) {
            previous = previous.next;
        }
        
        second = reverse(second);
        previous.next = second;
        
        return A;
    }
    
    public ListNode reverse(ListNode A) {
        
        ListNode current = A;
        ListNode previous = null;
        
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        
        return previous;
    }
}
