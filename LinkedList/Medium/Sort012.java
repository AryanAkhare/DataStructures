package Medium;

public class Sort012 {

    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // ---------------- BRUTE FORCE (COUNTING) ----------------
    static class BruteSolution {

        /*
 * Intuition:
 * Since the linked list contains only 0s, 1s, and 2s,
 * we count occurrences of each value in one traversal.
 * In the second traversal, we overwrite node values
 * in sorted order (0 → 1 → 2).
 *
 * Time Complexity: O(n)
 *   - One traversal for counting
 *   - One traversal for overwriting
 *
 * Space Complexity: O(1)
 *   - Uses only constant extra variables
 */

        public Node segregateBrute(Node head) {

            int count0 = 0, count1 = 0, count2 = 0;
            Node temp = head;

            // Count occurrences
            while (temp != null) {
                if (temp.data == 0) count0++;
                else if (temp.data == 1) count1++;
                else count2++;
                temp = temp.next;
            }

            temp = head;

            // Overwrite node values
            while (count0-- > 0) {
                temp.data = 0;
                temp = temp.next;
            }
            while (count1-- > 0) {
                temp.data = 1;
                temp = temp.next;
            }
            while (count2-- > 0) {
                temp.data = 2;
                temp = temp.next;
            }

            return head;
        }
    }

    // ---------------- OPTIMAL (POINTER / DUMMY NODES) ----------------
    static class OptimalSolution {

       /*
 * Intuition:
 * We create three separate linked lists using dummy nodes
 * to store nodes with values 0, 1, and 2.
 * We traverse the original list once and attach each node
 * to its respective list, then merge the lists as
 * 0-list → 1-list → 2-list.
 *
 * Time Complexity: O(n)
 *   - Single traversal of the linked list
 *
 * Space Complexity: O(1)
 *   - Uses constant extra pointers (no new data nodes)
 */
        public Node segregate(Node head) {

            Node zeroHead = new Node(-1);
            Node oneHead  = new Node(-1);
            Node twoHead  = new Node(-1);

            Node zero = zeroHead;
            Node one  = oneHead;
            Node two  = twoHead;

            Node temp = head;

            // Distribute nodes into 0s, 1s, and 2s lists
            while (temp != null) {
                if (temp.data == 0) {
                    zero.next = temp;
                    zero = zero.next;
                } 
                else if (temp.data == 1) {
                    one.next = temp;
                    one = one.next;
                } 
                else {
                    two.next = temp;
                    two = two.next;
                }
                temp = temp.next;
            }

            // Connect the lists
            zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
            one.next  = twoHead.next;
            two.next  = null;

            return zeroHead.next;
        }
    }
}
