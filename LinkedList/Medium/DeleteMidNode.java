package Medium;

/**
 * Problem: Delete the Middle Node of a Linked List
 *
 * Approach:
 * 1. Brute Force (2-pass)
 *    - Count total nodes
 *    - Delete (n/2)th node
 *
 * 2. Optimal (Slow & Fast Pointer)
 *    - Slow moves 1 step
 *    - Fast moves 2 steps
 *    - When fast reaches end, slow is just before middle
 *
 * Time Complexity:
 * - O(N) for both approaches
 *
 * Space Complexity:
 * - O(1)
 */

public class DeleteMidNode {

    // Node structure of singly linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Brute Force Approach
     * --------------------
     * Step 1: Count number of nodes
     * Step 2: Find middle index (count / 2)
     * Step 3: Traverse till node before middle
     * Step 4: Delete middle node
     */
    Node bruteDeleteMid(Node head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null)
            return null;

        // Count total nodes
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Middle index (0-based)
        int mid = count / 2;

        // Traverse to node before middle
        temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        // Delete middle node
        temp.next = temp.next.next;

        return head;
    }

    /**
     * Optimal Approach (Slow & Fast Pointer)
     * --------------------------------------
     * Slow pointer moves 1 step
     * Fast pointer moves 2 steps
     * Skip 1 node for slow when fast moves 2 steps
     * When fast reaches end, slow is before middle node
     */
    Node deleteMid(Node head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head.next.next;

        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete middle node
        slow.next = slow.next.next;

        return head;
    }
}
