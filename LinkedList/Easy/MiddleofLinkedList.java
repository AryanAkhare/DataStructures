package Easy;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

public class MiddleofLinkedList {

    /*
    =========================
    Intuition:
    =========================
    Use two pointers:
    - slow moves 1 step
    - fast moves 2 steps

    When fast reaches the end of the list,
    slow will be at the middle node.

    For even length lists, this returns
    the SECOND middle (as required by GFG).
    */

    /*
    =========================
    Approach:
    =========================
    1. Initialize slow and fast at head
    2. Move slow by 1 and fast by 2
    3. Stop when fast reaches null or last node
    4. slow.data is the answer
    */

    int getMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    /*
    =========================
    Time Complexity: O(n)
    Space Complexity: O(1)
    =========================
    */
}
