package Basics.DLL;

/*
|--------------------------------------------------------------------------
| Node Structure for Doubly Linked List
|--------------------------------------------------------------------------
*/
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

/*
|--------------------------------------------------------------------------
| Insert a node after p-th position (0-based index)
|--------------------------------------------------------------------------
| Given:
| - head of DLL
| - position p (0-based)
| - value x
|
| Task:
| Insert a node with value x just after p-th node
|
| Time Complexity  : O(n)
| Space Complexity : O(1)
*/
class Solution {

    Node insertAtPos(Node head, int p, int x) {

        if (head == null) return head;

        Node curr = head;

        // Move to p-th node
        for (int i = 0; i < p; i++) {
            if (curr == null) return head;
            curr = curr.next;
        }

        Node newNode = new Node(x);

        // Insert after curr
        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        }

        curr.next = newNode;

        return head;
    }
}

/*
|--------------------------------------------------------------------------
| Driver Code (for local testing)
|--------------------------------------------------------------------------
*/
public class InsertAfterPositionDLL {

    public static void main(String[] args) {

        // Create DLL: 1 <-> 2 <-> 3
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        Solution sol = new Solution();

        // Insert 99 after position p = 1 (after node 2)
        head = sol.insertAtPos(head, 1, 99);

        // Print DLL forward
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
