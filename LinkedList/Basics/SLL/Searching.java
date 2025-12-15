/**
 * Searching in a Singly Linked List
 */
class Node {
    int data;   // Value of node
    Node next;  // Pointer to next node

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Searching {

    /**
     * Iterative search in linked list
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static boolean iterativeSearch(Node head, int key) {
        Node curr = head; // Initialize current pointer

        while (curr != null) {
            if (curr.data == key) {
                return true; // Key found
            }
            curr = curr.next; // Move to next node
        }

        return false; // Key not found
    }

    /**
     * Recursive search in linked list
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack
     */
    static boolean recursiveSearch(Node head, int key) {
        if (head == null) {
            return false; // Reached end, key not found
        }
        if (head.data == key) {
            return true; // Key found
        }

        return recursiveSearch(head.next, key); // Check in rest of list
    }

    public static void main(String[] args) {
        // Create a hard-coded linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Key to search
        int key = 4;

        // Test iterative search
        if (iterativeSearch(head, key)) {
            System.out.println("Iterative: Key " + key + " found in the list.");
        } else {
            System.out.println("Iterative: Key " + key + " not found in the list.");
        }

        // Test recursive search
        if (recursiveSearch(head, key)) {
            System.out.println("Recursive: Key " + key + " found in the list.");
        } else {
            System.out.println("Recursive: Key " + key + " not found in the list.");
        }
    }
}

/**
 * Node class represents a node in a singly linked list
 */

