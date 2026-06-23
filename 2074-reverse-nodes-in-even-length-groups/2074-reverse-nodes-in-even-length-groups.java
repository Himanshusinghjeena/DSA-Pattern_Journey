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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {

            int count = 0;
            ListNode temp = curr;

            while (temp != null && count < groupSize) {
                count++;
                temp = temp.next;
            }

            if (count % 2 == 0) {

                ListNode prev = null;
                ListNode node = curr;

                for (int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = prev;
                    prev = node;
                    node = next;
                }

                prevGroupTail.next = prev;
                curr.next = node;

                prevGroupTail = curr;
                curr = node;
            } else {

                for (int i = 0; i < count; i++) {
                    prevGroupTail = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
}