package Medium;

import java.util.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortLL {

    /* =========================================================
       APPROACH 1: BRUTE FORCE
       Convert Linked List → Array → Sort → Rebuild List
       ========================================================= */

    /*
     * Intuition:
     * Linked lists are hard to sort directly.
     * Convert to array, use built-in sort, then rebuild LL.
     *
     * Time Complexity:
     * - Convert to array: O(n)
     * - Sorting array: O(n log n)
     * - Rebuild list: O(n)
     * => Total: O(n log n)
     *
     * Space Complexity:
     * - Extra array: O(n)
     */
    public ListNode sortListBrute(ListNode head) {
        if (head == null || head.next == null) return head;

        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        // LL -> Array
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // Sort array
        Collections.sort(arr);

        // Array -> LL
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = arr.get(i++);
            temp = temp.next;
        }

        return head;
    }

    /* =========================================================
       APPROACH 2: OPTIMAL (MERGE SORT ON LINKED LIST)
       ========================================================= */

    /*
     * Intuition:
     * - Linked list merge is efficient (no shifting)
     * - Split list using slow-fast pointer
     * - Recursively sort both halves
     * - Merge two sorted lists
     *
     * Time Complexity:
     * - Splitting: O(log n)
     * - Merging per level: O(n)
     * => Total: O(n log n)
     *
     * Space Complexity:
     * - Recursion stack: O(log n)
     * - No extra data structures
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;              // split list
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge2SortedLists(left, right);
    }

    // Merge two sorted linked lists
    public ListNode merge2SortedLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        temp.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }

    // Find left middle (important for merge sort)
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

