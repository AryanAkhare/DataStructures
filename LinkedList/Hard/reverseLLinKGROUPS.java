package Hard;

public class reverseLLinKGROUPS {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    /*
     * ========================== INTUITION ==========================
     * We reverse the linked list in groups of size k.
     * 
     * Instead of reversing the entire list at once:
     * - We reverse one group of k nodes at a time
     * - Then connect it with the previous reversed group
     * 
     * Key idea:
     * - Find the k-th node from current position
     * - Reverse nodes from current head to k-th node
     * - Fix links with previous and next groups
     * ==============================================================
     */

    public ListNode reverseKGroup(ListNode head, int k) {

        /*
         * ========================== APPROACH ==========================
         * 1. Use a pointer `temp` to traverse the list.
         * 2. For each group:
         * - Find the k-th node from temp.
         * - If k nodes are not available, attach remaining nodes as-is.
         * - Break the link after k-th node.
         * - Reverse the group.
         * - Connect previous group with current reversed group.
         * 3. Move temp to the next group.
         * ==============================================================
         */

        ListNode temp = head;
        ListNode prevLast = null; // tail of previous reversed group

        while (temp != null) {

            // Find k-th node from temp
            ListNode kthNode = getKthNode(temp, k);

            // If less than k nodes remain
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            // Store next group's starting node
            ListNode nextNode = kthNode.next;

            // Break link to isolate current group
            kthNode.next = null;

            // Reverse current k-group
            reverse(temp);

            // If this is the first group, update head
            if (temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }

            // Update prevLast to current group's tail
            prevLast = temp;

            // Move temp to next group
            temp = nextNode;
        }

        return head;
    }

    /*
     * ====================== GET K-TH NODE ======================
     * Returns the k-th node starting from temp.
     * If k nodes are not present, returns null.
     * ===========================================================
     */
    public ListNode getKthNode(ListNode temp, int k) {
        k = k - 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    /*
     * ====================== REVERSE LL ======================
     * Reverses a linked list and returns new head.
     * =======================================================
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /*
     * ===================== TIME COMPLEXITY =====================
     * O(N)
     * - Each node is visited a constant number of times.
     * 
     * ===================== SPACE COMPLEXITY =====================
     * O(1)
     * - In-place reversal, no extra space used.
     * ===========================================================
     */

}
