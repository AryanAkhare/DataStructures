// Demonstrates deletion operations in a Singly Linked List
// Operations:
// 1. Delete head
// 2. Delete end
// 3. Delete node at a specific position (1-based index)

public class Deletion {

    /*
     * Deletes the head node of the linked list
     * Time Complexity  : O(1)
     * Space Complexity : O(1)
     */
    public static Node deleteHead(Node head) {
        if (head == null) {
            return null; // empty list
        }
        return head.next; // move head to next node
    }

    /*
     * Deletes the last node of the linked list
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static Node deleteEnd(Node head) {
        if (head == null) {
            return null; // empty list
        }

        // only one node
        if (head.next == null) {
            return null;
        }

        Node current = head;

        // traverse to second last node
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null; // remove last node
        return head;
    }

    /*
     * Deletes a node at a given position (1-based index)
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static Node deleteAtPosition(Node head, int position) {

        // empty list or invalid position
        if (head == null || position < 1) {
            return head;
        }

        // delete head
        if (position == 1) {
            return head.next;
        }

        Node current = head;

        // move to node just before the target position
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        // if position exists, delete node
        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    /*
     * Prints the linked list
     */
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 8 -> 2 -> 3 -> 1 -> 7
        Node head = new Node(8);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(7);

        System.out.print("Original List: ");
        printList(head);

        // Delete head
        head = deleteHead(head);
        System.out.print("After deleting head: ");
        printList(head);

        // Delete end
        head = deleteEnd(head);
        System.out.print("After deleting end: ");
        printList(head);

        // Delete at position 2
        head = deleteAtPosition(head, 2);
        System.out.print("After deleting position 2: ");
        printList(head);
    }
}

/*
 * Node class for Singly Linked List
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
