package Easy;
/******************************************************
 * PROBLEM: Reverse a Singly Linked List
 *
 * DESCRIPTION:
 * Given the head of a singly linked list, reverse the
 * list and return the new head.
 *
 * You must reverse the list by changing the pointers,
 * NOT by changing the values.
 *
 * ----------------------------------------------------
 * Example:
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 5 -> 4 -> 3 -> 2 -> 1
 *
 * ----------------------------------------------------
 * CONSTRAINTS:
 * - The list may be empty
 * - The list may have only one node
 * - Must work in-place (no extra list)
 ******************************************************/

/******************************************************
 * DEFINITION FOR SINGLY LINKED LIST NODE
 ******************************************************/
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/******************************************************
 * SOLUTION CLASS
 ******************************************************/
class Solution {

    /**************************************************
     * ITERATIVE APPROACH
     *
     * INTUITION:
     * Each node in the list points to the next node.
     * To reverse the list, we must make each node
     * point to its previous node instead.
     *
     * BUT:
     * If we change curr.next directly, we lose the
     * rest of the list.
     *
     * So we use 3 pointers:
     * 1. prev -> reversed part
     * 2. curr -> current node
     * 3. next -> saves remaining list
     *
     * STEPS:
     * 1. Save next node
     * 2. Reverse pointer
     * 3. Move pointers forward
     * 4. Repeat until curr becomes null
     **************************************************/
    public ListNode reverseListIterative(ListNode head) {

        ListNode prev = null;     // previous node
        ListNode curr = head;     // current node
        ListNode next = null;     // next node

        while (curr != null) {

            // Step 1: save next node
            next = curr.next;

            // Step 2: reverse pointer
            curr.next = prev;

            // Step 3: move pointers forward
            prev = curr;
            curr = next;
        }

        // prev becomes new head
        return prev;
    }

    /**************************************************
     * RECURSIVE APPROACH
     *
     * INTUITION:
     * Think in terms of:
     * "Reverse the rest of the list, then fix my node"
     *
     * If head -> 1 -> 2 -> 3 -> null
     * First reverse 2 -> 3
     * Then make:
     * 2 -> 1
     * and set 1 -> null
     *
     * BASE CASE:
     * - Empty list
     * - Single node list
     **************************************************/
    public ListNode reverseListRecursive(ListNode head) {

        // Base case: empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);

        // Fix current node
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**************************************************
     * TIME & SPACE COMPLEXITY
     *
     * ITERATIVE:
     * Time Complexity:  O(n)
     * Space Complexity: O(1)
     *
     * RECURSIVE:
     * Time Complexity:  O(n)
     * Space Complexity: O(n)  (recursion stack)
     **************************************************/
}
