package Basics.CLL;

/**
 * Deletion operations in Circular Linked List
 * Assumption: "last" node is given
 */
public class DeletionCLL {

    /* ---------------------------------------------------------
       Delete at Beginning
       Time: O(1)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node deleteAtBeginning(Node last) {

        // Empty list
        if (last == null) return null;

        Node head = last.next;

        // Only one node
        if (head == last) {
            return null;
        }

        // More than one node
        last.next = head.next;

        return last;
    }

    /* ---------------------------------------------------------
       Delete a Specific Node (by value)
       Time: O(n)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node deleteAtSpecificNode(Node last, int key) {

        // Empty list
        if (last == null) return null;

        Node curr = last.next; // head
        Node prev = last;

        // Case: only one node
        if (curr == last && curr.data == key) {
            return null;
        }

        // Traverse to find node
        do {
            if (curr.data == key) {

                // Deleting head
                if (curr == last.next) {
                    last.next = curr.next;
                }
                // Deleting last
                else if (curr == last) {
                    prev.next = curr.next;
                    last = prev;
                }
                // Deleting middle node
                else {
                    prev.next = curr.next;
                }

                return last;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != last.next);

        // Key not found
        return last;
    }

    /* ---------------------------------------------------------
       Delete at End
       Time: O(n)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node deleteAtEnd(Node last) {

        // Empty list
        if (last == null) return null;

        Node head = last.next;

        // Only one node
        if (head == last) {
            return null;
        }

        // Traverse to second-last node
        Node curr = head;
        while (curr.next != last) {
            curr = curr.next;
        }

        curr.next = head;
        last = curr;

        return last;
    }
}
