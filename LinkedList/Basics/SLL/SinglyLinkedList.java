package LinkedList.Basics.SLL;

/**
 * Node class represents a single node in a singly linked list
 */
class Node {
    int data;    // Data part
    Node next;   // Pointer to next node

    // Constructor to initialize node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * SinglyLinkedList class demonstrates basic operations on SLL
 */
public class SinglyLinkedList {

    /**
     * Iterative traversal of linked list
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void traverseList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println(); // Move to next line after printing list
    }

    /**
     * Recursive traversal of linked list
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack
     */
    public static void recursiveTraverseList(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        System.out.print(head.data);
        if (head.next != null) {
            System.out.print("->");
        }

        recursiveTraverseList(head.next);
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        // Print list iteratively
        System.out.println("Iterative Traversal:");
        traverseList(head);

        // Print list recursively
        System.out.println("Recursive Traversal:");
        recursiveTraverseList(head);
    }
}
