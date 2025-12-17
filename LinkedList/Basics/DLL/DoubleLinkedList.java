package Basics.DLL;

/*
|--------------------------------------------------------------------------
| Node Structure for Doubly Linked List
|--------------------------------------------------------------------------
| Each node contains:
| - data  : value stored in the node
| - prev  : reference to previous node
| - next  : reference to next node
*/
class Node {
    int data;
    Node prev;
    Node next;

    // Constructor
    Node(int value) {
        this.data = value;
        this.prev = null;
        this.next = null;
    }
}

/*
|--------------------------------------------------------------------------
| Doubly Linked List Traversal
|--------------------------------------------------------------------------
| Demonstrates:
| 1. Forward Traversal
| 2. Backward Traversal
*/
public class DoubleLinkedList {

    /*
    |--------------------------------------------------------------------------
    | Forward Traversal
    |--------------------------------------------------------------------------
    | Start from head and move using next pointer
    |
    | Time Complexity  : O(n)
    | Space Complexity : O(1)
    */
   // Function to construct doubly linked list from array
    Node constructDLL(int arr[]) {

        // If array is empty
        if (arr.length == 0) return null;

        // Step 1: Create head
        Node head = new Node(arr[0]);
        Node curr = head;

        // Step 2: Traverse array and build DLL
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);

            curr.next = newNode;   // forward link
            newNode.prev = curr;   // backward link

            curr = newNode;        // move pointer
        }

        return head;
    }
    public static void forwardTraversal(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /*
    |--------------------------------------------------------------------------
    | Backward Traversal
    |--------------------------------------------------------------------------
    | Start from tail and move using prev pointer
    |
    | Time Complexity  : O(n)
    | Space Complexity : O(1)
    */
    public static void backwardTraversal(Node tail) {
        Node curr = tail;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    /*
    |--------------------------------------------------------------------------
    | Driver Code
    |--------------------------------------------------------------------------
    | Creates a doubly linked list:
    | 1 <-> 2 <-> 3
    */
    public static void main(String[] args) {

        // Creating nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        // Linking nodes (forward + backward)
        head.next = second;

        second.prev = head;
        second.next = third;

        third.prev = second;

        // Traversals
        System.out.println("Forward Traversal:");
        forwardTraversal(head);

        System.out.println("Backward Traversal:");
        backwardTraversal(third);
    }
}
