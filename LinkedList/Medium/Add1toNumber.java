// ===============================
// Add 1 to a Number
// Works for BOTH:
// 1) Linked List
// 2) Array
// ===============================

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Add1toNumber {

    // -------------------------------------------------
    // LINKED LIST PART
    // -------------------------------------------------

    /*
     * INTUITION (TUF style):
     * We need to add 1 starting from the last digit.
     * But singly linked list does not allow backward traversal.
     * So we reverse the list, perform normal addition with carry,
     * then reverse it back.
     */

    /*
     * APPROACH:
     * 1. Reverse the linked list
     * 2. Initialize carry = 1
     * 3. Traverse and update digits
     * 4. If carry remains, add new node
     * 5. Reverse back and return
     */

    // Reverse a linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Add 1 to linked list number
    public Node add1toLinkedList(Node head) {

        // Step 1: Reverse the list
        head = reverse(head);

        Node temp = head;
        int carry = 1;

        // Step 2: Add carry like normal addition
        while (temp != null && carry > 0) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            // Step 3: If end reached and carry still exists
            if (temp.next == null && carry > 0) {
                temp.next = new Node(carry);
                carry = 0;
            }

            temp = temp.next;
        }

        // Step 4: Reverse back
        return reverse(head);
    }

    /*
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     */


    // -------------------------------------------------
    // ARRAY PART
    // -------------------------------------------------

    /*
     * INTUITION (TUF style):
     * In array, last index represents least significant digit.
     * So we start from the end, add 1, and propagate carry.
     * If carry remains after full traversal, create new array.
     */

    /*
     * APPROACH:
     * 1. Start from last index
     * 2. Add carry (=1)
     * 3. Update digit and carry
     * 4. If carry still remains, increase array size
     */

    public static int[] addOne(int[] arr) {
        int n = arr.length;
        int carry = 1;

        // Step 1: Traverse from last digit
        for (int i = n - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            arr[i] = sum % 10;
            carry = sum / 10;

            // Early stop if no carry
            if (carry == 0)
                break;
        }

        // Step 2: If carry still exists
        if (carry == 1) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }

        return arr;
    }

    /*
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     */
}
