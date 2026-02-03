package Medium;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

public class SortInsertion {

    /*
     * Intuition:
     * Build a sorted list by inserting nodes one by one
     *
     * Time Complexity:
     * - Best case (already sorted): O(n)
     * - Average / Worst case: O(n^2)
     *
     * Space Complexity:
     * - O(1) (in-place)
     *
     * Stable Sort: YES
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1); // sorted list dummy
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // save next

            // find correct position in sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            curr = nextNode;
        }

        return dummy.next;
    }
}


