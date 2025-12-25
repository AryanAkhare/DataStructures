public class RemoveNthNodeFromEnd {

    /* 
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
     * ============================================================
     * APPROACH 1: BRUTE FORCE (USING ARRAYLIST)
     * ============================================================
     *
     * INTUITION:
     * Convert the linked list into an indexed structure (ArrayList).
     * Once we know the size, removing the (size - n)th node becomes easy.
     *
     * STEPS:
     * 1. Traverse the list and store all nodes in ArrayList
     * 2. Compute index = size - n
     * 3. Adjust pointers to skip that node
     *
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     */
    static ListNode removeNthFromEndBrute(ListNode head, int n) {
        if (head == null) return head;

        java.util.ArrayList<ListNode> list = new java.util.ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int size = list.size();
        int idx = size - n;

        // delete head
        if (idx == 0) {
            return head.next;
        }

        list.get(idx - 1).next = list.get(idx).next;
        return head;
    }

    /*
     * ============================================================
     * APPROACH 2: TWO PASS COUNTING (BETTER)
     * ============================================================
     *
     * INTUITION:
     * If we know the length of the list, we can directly locate
     * the node just before the one to delete.
     *
     * STEPS:
     * 1. First pass → count total nodes
     * 2. If n == length → remove head
     * 3. Move to (length - n - 1)th node
     * 4. Delete its next node
     *
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     */
    static ListNode removeNthFromEndCounting(ListNode head, int n) {
        if (head == null || n < 1) return head;

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // delete head
        if (n == count) {
            return head.next;
        }

        ListNode temp = head;
        for (int i = 1; i < count - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    /*
     * ============================================================
     * APPROACH 3: OPTIMAL (ONE PASS – TWO POINTER)
     * ============================================================
     *
     * INTUITION:
     * Keep two pointers such that the distance between them is n.
     * When the fast pointer reaches the end, the slow pointer
     * will be just before the node to delete.
     *
     * Dummy node is used to handle edge case of deleting head.
     *
     * STEPS:
     * 1. Create dummy node before head
     * 2. Move fast pointer n steps ahead
     * 3. Move both pointers until fast reaches end
     * 4. Delete slow.next
     *
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * ⭐ BEST APPROACH
     */
    static ListNode removeNthFromEndOptimal(ListNode head, int n) {
        if (head == null || n < 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    /*
     * ================== MAIN (FOR LOCAL TESTING) ==================
     */
    public static void main(String[] args) {

        // Creating list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Choose any approach
        head = removeNthFromEndOptimal(head, 2);

        // Print result
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
