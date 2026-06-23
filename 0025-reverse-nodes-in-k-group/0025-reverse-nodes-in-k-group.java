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
    public ListNode reverseKGroup(ListNode head, int k) {

        int len = totalLength(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (len >= k) {

            ListNode curr = groupPrev.next;
            ListNode prev = null;

            
            ListNode tail = curr;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            groupPrev.next = prev;

            tail.next = curr;

            groupPrev = tail;

            len -= k;
        }

        return dummy.next;
    }

     int totalLength(ListNode curr) {
        int len = 0;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }
}