package Medium;

/**
 * LeetCode 237. Delete Node in a Linked List
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a node from a singly linked list.
 * You do NOT have access to the head of the list.
 * It is guaranteed that the given node is NOT the last node.
 *
 * Task:
 * Delete the given node such that:
 * - The value of the given node no longer exists in the list
 * - The number of nodes decreases by one
 * - The order of nodes before and after remains unchanged
 *
 * Key Insight:
 * Since we don't have access to the previous node or head,
 * we copy the data of the next node into the current node
 * and then bypass the next node.
 *
 * Time Complexity  : O(1)
 * Space Complexity : O(1)
 */
public class DeleteNode {

    /**
     * Deletes the given node from the linked list
     *
     * @param node the node to be deleted (guaranteed not to be the last node)
     */
    public void deleteNode(ListNode node) {

        // Safety check (not strictly needed as per problem constraints)
        if (node == null || node.next == null) {
            return;
        }

        // Copy next node's data into current node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }


    public static void main(String[] args) {
        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Node to delete (node with value 5)
        ListNode nodeToDelete = head.next;

        DeleteNode solution = new DeleteNode();
        solution.deleteNode(nodeToDelete);

        // Print list after deletion
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
    }

}
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

