package Medium;

/*
 ============================
  Node Definition
 ============================
*/
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/*
 =====================================================
  Problem:
  Segregate Even and Odd Nodes (by VALUE)
 =====================================================

  - All EVEN numbers should appear before ODD numbers
  - Relative order must be preserved
  - Do NOT create a new linked list
  - Rearrange pointers in-place
*/

public class OddEvenList {

    /*
     -------------------------
     Optimal Approach (TUF)
     -------------------------
     Intuition:
     - Maintain two separate chains:
       1) Even-valued nodes
       2) Odd-valued nodes
     - Traverse once and attach nodes accordingly
     - Finally connect even list to odd list
    */

    Node divide(Node head) {
        if (head == null) return null;

        // Heads and tails for even & odd lists
        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node curr = head;

        // Traverse the list once
        while (curr != null) {

            if (curr.data % 2 == 0) {   // EVEN value
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } else {                    // ODD value
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }

            curr = curr.next;
        }

        // If there are no even nodes, return original odd list
        if (evenHead == null) return oddHead;

        // Attach odd list after even list
        evenTail.next = oddHead;

        // Important: terminate final list
        if (oddTail != null) oddTail.next = null;

        return evenHead;
    }
}
