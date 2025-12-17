package Basics.DLL;

/*
|--------------------------------------------------------------------------
| Node Structure for Doubly Linked List
|--------------------------------------------------------------------------
| data : value stored in node
| prev : reference to previous node
| next : reference to next node
*/
class Node {
    int data;
    Node prev;
    Node next;

    Node(int value) {
        this.data = value;
        this.prev = null;
        this.next = null;
    }
}

/*
|--------------------------------------------------------------------------
| Deletion in Doubly Linked List
|--------------------------------------------------------------------------
| 1. Delete Head
| 2. Delete Tail
| 3. Delete Node at Given Position (1-based)
*/
public class DeletionDLL {

    /*
    |--------------------------------------------------------------------------
    | Delete Head
    |--------------------------------------------------------------------------
    | Steps:
    | 1. Move head to next node
    | 2. Set new head.prev = null
    |
    | Time Complexity  : O(1)
    | Space Complexity : O(1)
    */
    public static Node delHead(Node head) {
        if (head == null) return null;

        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        return head;
    }

    /*
    |--------------------------------------------------------------------------
    | Delete Tail
    |--------------------------------------------------------------------------
    | Steps:
    | 1. Traverse to last node
    | 2. Set second last node.next = null
    |
    | Time Complexity  : O(n)
    | Space Complexity : O(1)
    */
    public static Node delTail(Node head) {
        if (head == null) return null;
        if (head.next == null) return null;

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;

        return head;
    }

    /*
    |--------------------------------------------------------------------------
    | Delete Node at Given Position (1-based index)
    |--------------------------------------------------------------------------
    | Steps:
    | 1. If pos == 1, delete head
    | 2. Traverse to pos-th node
    | 3. Update prev and next links
    |
    | Time Complexity  : O(n)
    | Space Complexity : O(1)
    */
    public static Node deletePosition(Node head, int pos) {

        if (head == null) return null;

        // Case 1: Delete head
        if (pos == 1) {
            return delHead(head);
        }

        Node curr = head;

        // Move to pos-th node
        for (int i = 1; i < pos; i++) {
            if (curr == null) {
                return head; // position out of bounds
            }
            curr = curr.next;
        }

        if (curr == null) return head;

        // Update links
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        return head;
    }

    /*
    |--------------------------------------------------------------------------
    | Driver Code
    |--------------------------------------------------------------------------
    */
    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;

        second.prev = head;
        second.next = third;

        third.prev = second;
        third.next = fourth;

        fourth.prev = third;

        // Delete operations
        head = delHead(head);        // delete 1
        head = delTail(head);        // delete 4
        head = deletePosition(head, 2); // delete 3

        // Forward traversal
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
