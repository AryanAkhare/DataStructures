package Medium;

import static java.util.Collections.reverse;

/*
Problem: Add Two Numbers (LeetCode)
Digits are stored in reverse order.
*/

public class AddTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int carry = 0;
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while (l1 != null || l2 != null) {

                int sum = carry;
                if (l1 != null) sum += l1.val;
                if (l2 != null) sum += l2.val;

                curr.next = new ListNode(sum % 10);
                carry = sum / 10;
                curr = curr.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }

            return dummy.next;
        }
    }/*
Problem: Add Number Linked Lists (GFG)
Digits are stored in forward order.
Leading zeros allowed in input, NOT allowed in output.
*/

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}



    // Reverse linked list
    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Remove leading zeros
    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return (head == null) ? new Node(0) : head;
    }

    public Node addTwoLists(Node head1, Node head2) {

        // Step 1: Reverse both lists
        head1 = reverse(head1);
        head2 = reverse(head2);

        // Step 2: Add like normal addition
        int carry = 0;
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head1 != null || head2 != null) {

            int sum = carry;
            if (head1 != null) sum += head1.data;
            if (head2 != null) sum += head2.data;

            curr.next = new Node(sum % 10);
            carry = sum / 10;
            curr = curr.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        if (carry > 0) {
            curr.next = new Node(carry);
        }

        // Step 3: Reverse result back
        Node result = reverse(dummy.next);

        // Step 4: Remove leading zeros
        return removeLeadingZeros(result);
    }
}

