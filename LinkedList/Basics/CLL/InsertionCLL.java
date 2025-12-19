package Basics.CLL;

/**
 * Node structure for Circular Linked List
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionCLL {

    /* ---------------------------------------------------------
       Insert at Head (Only head given)
       Time: O(n)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node insertAtHead(Node head, int key) {
        Node newNode = new Node(key);

        // Empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Find last node
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;

        return newNode; // new head
    }

    /* ---------------------------------------------------------
       Insert at Head (O(1) trick using data swap)
       Time: O(1)
       Space: O(1)
       NOTE: Head reference does NOT change
    --------------------------------------------------------- */
    public static Node insertAtHeadOptimal(Node head, int key) {
        Node newNode = new Node(key);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Insert after head
        newNode.next = head.next;
        head.next = newNode;

        // Swap data
        int temp = head.data;
        head.data = newNode.data;
        newNode.data = temp;

        return head; // IMPORTANT
    }

    /* ---------------------------------------------------------
       Insert at Head (Last node given)
       Time: O(1)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node insertAtHeadIfLastGiven(Node last, int key) {
        Node newNode = new Node(key);

        if (last == null) {
            newNode.next = newNode;
            return newNode;
        }

        newNode.next = last.next; // last.next = head
        last.next = newNode;

        return last;
    }

    /* ---------------------------------------------------------
       Insert at End (Tail given)
       Time: O(1)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node insertAtEnd(Node tail, int key) {
        Node newNode = new Node(key);

        if (tail == null) {
            newNode.next = newNode;
            return newNode;
        }

        newNode.next = tail.next; // tail.next = head
        tail.next = newNode;

        return newNode; // new tail
    }

    /* ---------------------------------------------------------
       Insert at End (Only head given)
       Time: O(n)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node insertAtEndGivenHead(Node head, int key) {
        Node newNode = new Node(key);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;

        return head;
    }

    /* ---------------------------------------------------------
       Insert at a given position (Last node given)
       Positions are 1-based
       Time: O(n)
       Space: O(1)
    --------------------------------------------------------- */
    public static Node insertAtPosition(Node last, int data, int pos) {

        // Empty list
        if (last == null) {
            if (pos != 1) {
                System.out.println("Invalid position");
                return null;
            }
            Node newNode = new Node(data);
            newNode.next = newNode;
            return newNode;
        }

        Node newNode = new Node(data);
        Node curr = last.next; // head

        // Insert at head
        if (pos == 1) {
            newNode.next = curr;
            last.next = newNode;
            return last;
        }

        // Traverse to (pos - 1)
        for (int i = 1; i < pos - 1; i++) {
            curr = curr.next;
            if (curr == last) {
                System.out.println("Position out of bounds");
                return last;
            }
        }

        newNode.next = curr.next;
        curr.next = newNode;

        // If inserted at end, update last
        if (curr == last) {
            last = newNode;
        }

        return last;
    }

    /* ---------------------------------------------------------
       Print Circular Linked List
       Time: O(n)
       Space: O(1)
    --------------------------------------------------------- */
    public static void printCircularLinkedList(Node last) {
        if (last == null) return;

        Node head = last.next;
        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }
    static boolean isCircular(Node head) {
        // Your code here
        // Empty list is NOT circular
    if (head == null) return false;

    Node curr = head.next;

    while (curr != null && curr != head) {
        curr = curr.next;
    }

    return curr == head;
    }
}


// Interview Summary (remember this)

// Head only → traversal needed

// Tail given → O(1) operations

// O(1) head insertion uses data swap

// Return updated reference always (head or tail)


