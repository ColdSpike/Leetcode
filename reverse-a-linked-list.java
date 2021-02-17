/*
Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return rec(head);
    }

    private ListNode rec(ListNode root) {
        if (root.next == null) {
            return root;
        }

        ListNode node = rec(root.next);
        root.next.next = root;
        root.next = null;

        return node;
    }

}

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
        ListNode nextTemp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = nextTemp;
    }
    return prev;
}