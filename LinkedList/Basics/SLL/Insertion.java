// Demonstrates insertion operations in a Singly Linked List
// Operations:
// 1. Insert at front
// 2. Insert at end
// 3. Insert at a given position

public class Insertion {

    /*
     * Inserts a node at the front of the linked list
     * Time Complexity  : O(1)
     * Space Complexity : O(1)
     */
    public static Node insertAtFront(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode; // new node becomes the new head
    }

    /*
     * Inserts a node at the end of the linked list
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static Node insertAtEnd(Node head, int value) {
        Node newNode = new Node(value);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    /*
     * Inserts a node at a specific position (1-based index)
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static Node insertAtPosition(Node head, int position, int value) {
        // Invalid position
        if (position < 1) return head;

        // Insert at head (position = 1)
        if (position == 1) {
            return insertAtFront(head, value);
        }

        Node current = head;

        // Traverse to the node just before the target position
        for (int i = 1; i < position - 1 ; i++) {
            if(current!=null){
            current = current.next;
            }
        }

        // If position is greater than list length
        if (current == null) return head;

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;

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
        // Create initial linked list: 2 -> 3 -> 4 -> 5
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        // Insert at front
        head = insertAtFront(head, 1); // 1 -> 2 -> 3 -> 4 -> 5

        // Insert at end
        head = insertAtEnd(head, 6);   // 1 -> 2 -> 3 -> 4 -> 5 -> 6

        // Insert at position 3
        head = insertAtPosition(head, 3, 99); // 1 -> 2 -> 99 -> 3 -> 4 -> 5 -> 6

        // Print final list
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
