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
    public ListNode removeNodes(ListNode head) {
        // if (head == null || head.next == null) {return head;}
        ListNode reverse = null, result = null;
        for (; head != null;) {
            ListNode help = head.next;
            head.next = reverse;
            reverse = head;
            head = help;
        }
        int max = reverse.val;
        result = reverse;
        reverse = reverse.next;
        result.next = null;
        for (; reverse != null;) {
            if (max <= reverse.val) {
                max = reverse.val;
                ListNode help = reverse.next;
                reverse.next = result;
                result = reverse;
                reverse = help;
            } else {
                reverse = reverse.next;
            }
        }
        return result;
    }
}
